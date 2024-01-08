package com.adaptionsoft.games.trivia.runner

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PrintStream
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

object GoldenMaster {
    private val BYTE_ENCODING: Charset = StandardCharsets.UTF_8

    fun getResult(i: Int): String {
        return try {
            String(
                Files.readAllBytes(
                    Paths.get("src", "test", "resources", String.format("output%d.txt", i))
                ), BYTE_ENCODING
            )
        } catch (e: IOException) {
            generateExpectedResult(i)
        }
    }

    private fun generateExpectedResult(i: Int): String {
        val originalOut = System.out
        return try {
            ByteArrayOutputStream().use { outContent ->
                PrintStream(outContent, true, BYTE_ENCODING.name()).use { interceptingStream ->
                    System.setOut(interceptingStream)

                    GameRunner.main(arrayOf(Integer.toString(i)))

                    Files.write(
                        Paths.get("src", "test", "resources", String.format("output%d.txt", i)),
                        outContent.toByteArray()
                    )
                    outContent.toString()
                }
            }
        } catch (e: IOException) {
            throw RuntimeException("Failed to generate the expected result for iteration $i", e)
        } finally {
            System.setOut(originalOut)
        }
    }
}
