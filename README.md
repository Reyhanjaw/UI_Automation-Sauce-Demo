# SauceDemo UI Automation Testing Framework

## 1. Project Overview

This project is a UI automation testing framework for the SauceDemo e-commerce website.

The framework uses Selenium WebDriver for browser automation, Cucumber with Gherkin for behavior-driven development (BDD), Java as the programming language, Gradle for build and dependency management, and JUnit Platform to execute automated tests.

The current implementation focuses on testing the login functionality, including positive, negative, and boundary test scenarios.

**Application Under Test:** https://www.saucedemo.com/

## 2. Technologies Used

- Java
- Gradle
- Selenium WebDriver
- Cucumber
- Gherkin
- JUnit Platform
- Google Chrome

## 3. Framework Design

This project applies the Page Object Model (POM) design pattern.

- **Page Object (`LoginPage.java`):** Contains page locators and methods for interacting with the login page.
- **Step Definitions (`LoginSteps.java`):** Implements the steps defined in the Gherkin feature file.
- **Feature File (`Login.feature`):** Describes the login test scenarios using Gherkin syntax.
- **Test Runner (`TestRunner.java`):** Configures and executes Cucumber scenarios through JUnit Platform.

## 4. Test Scenarios

The login feature currently includes four scenarios:

1. Successful login with valid credentials.
2. Login with invalid credentials.
3. Login with empty username and password.
4. Login with a very long username of 500 characters.

The tests verify successful navigation to the Products page and validate the expected login error messages.

## 5. Test Credentials

The following SauceDemo test account is used for the successful login scenario:

- Username: `performance_glitch_user`
- Password: `secret_sauce`

Invalid and boundary test data are used in the negative scenarios.

## 6. Prerequisites

Before running the tests, ensure the following are installed:

- A compatible Java Development Kit (JDK).
- Gradle Wrapper included in the project.
- Google Chrome browser.
- IntelliJ IDEA or another Java IDE (optional).

## 7. How to Run the Tests

On Windows, open a terminal in the project root directory and execute:

```powershell
.\gradlew.bat clean test
```

The command cleans the previous build outputs and executes the automated test suite.

## 8. Test Reports

Cucumber HTML reports are generated at:

`build/reports/cucumber/cucumber.html`

Open the HTML file in a browser to review the execution results and scenario details.

## 9. Project Status

The current login test suite contains four scenarios covering positive, negative, and boundary test cases.

All four scenarios passed in the latest recorded test execution.