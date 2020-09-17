# Preparatory Instructions for Apprentices

--

## Make sure you have a Miro account

* If you don't then go to [miro.com](http://miro.com) and sign up (it's free)
* We'll be using it for collaborative drawings and post-its

--

## Fork and get the code

* Go here:  
  https://github.com/MCR-Digital/apprentice-boot-camp-improving-code
* Click the **Fork** button to make your own copy of the repository
* ⚠️ Don’t use the IDE to clone the project, as you will not be working from the root of the project—do this instead:  
  `git clone https://github.com/<YOUR_USERNAME>/apprentice-boot-camp-improving-code`

--

## Get the project building

* Non-Java folk
  * Find the folder for your language in the `exercises` folder—this is where you will be working
  * Run the build as you usually would
  * Run `GameRunnerTest` and check it passes
  * Let us know on Slack if you have any problems!
* Java folk
  * There are detailed instructions on the next page for you

--

## IntelliJ instructions

* Choose File > New > Project from Existing Sources…
* Open the `exercises/java` directory and choose the ‘Gradle’ option under ‘Import project from external model’
* Choose View > Tool Windows > Gradle
* Click 🔄 to reimport the project
* Click 🔧, then ‘Gradle Settings…’
* Change ‘Build and run using’ & ‘Run tests using’ to ‘IntelliJ IDEA’
* Run `GameRunnerTest` and check it passes

Notes: Use https://www.jetbrains.com/help/idea/work-with-gradle-projects.html#delegate_build_actions to fix test running