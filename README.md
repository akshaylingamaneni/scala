# Scala Project

## Overview
This project is a simple Scala application that is playground to test and learn Scala programming language.

## Prerequisites
- Scala
- sbt (Simple Build Tool)

## Project Structure
- `src/main/scala/`: Contains the main source code.
- `src/test/scala/`: Contains the test code.
- `project/Dependencies.scala`: Manages project dependencies.
- `.gitignore`: Specifies files and directories to be ignored by Git.

## Dependencies
The project uses the following dependencies:
- ScalaTest: Version 3.2.16
- MUnit: Version 1.0.0-M10

## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using sbt:
    ```sh
    sbt run
    ```

## How to Test
To run the tests, use the following sbt command:
```sh
sbt test