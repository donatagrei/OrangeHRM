# OrangeHRM Automated UI Tests

This repository contains **automated UI tests** written in **Java**, using **Selenium WebDriver** and **JUnit 5** for testing the [**OrangeHRM**]([https://themes.woocommerce.com/homestore/](https://opensource-demo.orange)) HR management web application.

## Overview

The automated tests validate key functionalities within the Recruitment module of the OrangeHRM web application, focusing on:
- Candidate Form Management: testing form navigation, data validation, and error handling.
- Email Format Validation: verifying the expected email format in candidate forms.
- Candidate Information Management: ensuring data input, file uploads, and information saving work as intended.

## Prerequisites

Before running the automated tests, ensure the following are installed:
- **Java Development Kit (JDK) 17** or later
- **Maven** for dependency management
- **Google Chrome** (or another supported browser)
- **Chromedriver** (compatible with your Chrome version)
- 
## Setup

1. **Clone this repository:**
   ```bash
   git clone https://github.com/donatagrei/donatagrei/OrangeHRM.git
   
2. **Navigate to the project directory:**
   ```bash
   cd OrangeHRM

3. **Install the required dependencies using Maven:**
   ```bash
   mvn clean install

## Tests execution

### Using Maven
To execute all tests, run:
  ```bash
  mvn test
  ```

### Using IDE
Tests can also be run individually from an IDE such as IntelliJ IDEA or Eclipse by selecting and running specific test classes.

## Folder structure

- **/src/test/java/pages:** contains the utility classes, test pages.
- **/src/test/java/tests:** contains the test cases.
- **/src/test/utils:** contains utility classes.
  
## Project structure

Tests are structured using POM (Page Object Model), allowing for easy readability and maintenance. The tests are organized as follows:
- **BasePage:** provides common methods for interacting with web elements and navigating the application.
- **RecruitmentPage:** includes methods for interacting with the recruitment section, such as filling candidate forms, validation, and saving data.
- **BaseTest:** contains setup and teardown methods for initializing the WebDriver and managing browser sessions.
- **CandidateFormTest:** tests the candidate form functionality, including navigation, validation, and data submission scenarios.
- **Generator:** utility class that generates random test data using JavaFaker.

## Dependencies

The project relies on the following dependencies, as specified in the `pom.xml` file:

- **Selenium Java:** version 4.25.0
- **JUnit Jupiter API:** version 5.11.3
- **JUnit Jupiter Params:** version 5.11.3
- **JavaFaker:** version 1.0.0
- **AssertJ Core:** version 3.26.3 

## Author

Donata Greičiūtė - donata.greiciute97@gmail.com
