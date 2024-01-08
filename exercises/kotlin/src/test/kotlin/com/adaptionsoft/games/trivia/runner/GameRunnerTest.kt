package com.adaptionsoft.games.trivia.runner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PrintStream

class GameRunnerTest {

    private val outContent = ByteArrayOutputStream()
    private val originalOut: PrintStream = System.out

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    @Throws(IOException::class)
    fun restoreStreams() {
        System.setOut(originalOut)
        outContent.close()
    }

    @Test
    fun goldenMaster() {
        for (i in 0 until 10000) {
            GameRunner.main(arrayOf(i.toString()))
            assertThat(outContent.toString()).isEqualTo(GoldenMaster.getResult(i))
            outContent.reset()
        }
    }
}
