# Entrata Automated Tests

This project contains automated tests for the Entrata web application, written using Java with Selenium WebDriver and TestNG framework. The tests verify various functionalities of the Entrata application, such as the "Schedule Demo" functionality, desktop version links, and the Resident Login page.

## Project Structure

- **Package Name**: `test.Assesment.test`
- **Base Class**: `assesment.Entrata.SetUpBase` (this handles the setup of the WebDriver and other configurations for the tests).
- **Test Class**: `EntrataTests` (contains all test methods).

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed on your machine.
2. **Maven**: This project uses Maven to manage dependencies. Make sure Maven is installed and properly configured in your system.
3. **WebDriver**: The project requires WebDriver for your preferred browser (e.g., ChromeDriver, GeckoDriver for Firefox).
4. **TestNG**: Ensure that TestNG is installed, either through Maven or directly in your IDE.

## Dependencies

The following dependencies are required in the `pom.xml` file:
- Selenium WebDriver
- TestNG
- WebDriverManager (optional but useful to handle browser drivers)



## How to Run the Tests

### Step 1: Run the Tests

You can run the tests using TestNG directly in your IDE or via the command line:

- **Using IDE**: Right-click on the `EntrataTests` class and select `Run As` > `TestNG Test`

### Step 2: Review Test Results

The test results will be displayed in the console output. You can also view a detailed report using TestNG’s HTML report, which will be generated in the `test-output` folder.

## Test Cases Overview

### 1. **Test: ScheduleDemo**

   - **Purpose**: This test verifies that the "Schedule Demo" feature works as expected.
   - **Steps**:
     1. Click on the "Schedule Demo" button.
     2. Switch focus to the new window.
     3. Fill in the form fields with valid data (First Name, Last Name, Email, Company, Phone).
     4. Select options from the dropdown menus.
     5. Verify if the "Schedule Demo" button is enabled (clickable).
   - **Assertions**: Ensures that the form can be submitted successfully and the button is clickable.

### 2. **Test: checkDesktopVersionLinks**

   - **Purpose**: This test checks that all desktop version links are clickable and functional.
   - **Steps**:
     1. Locate all the links under the "desktop-version" section.
     2. Verify each link is enabled.
     3. Click on each link and navigate back.
   - **Assertions**: Confirms that all the desktop version links are working properly.

### 3. **Test: validateResidateLoginPage**

   - **Purpose**: This test validates the Resident Login page's navigation and content.
   - **Steps**:
     1. Click on the "Sign In" button.
     2. Click on the "Resident" option in the login menu.
     3. Verify that the title of the Resident Portal page matches the expected value.
   - **Assertions**: Ensures that the Resident Portal page is displayed and the title matches "Welcome to the Resident Portal App".

---

### Reporting

The tests use TestNG’s built-in `Reporter.log()` to log outputs during execution. You can view the detailed reports in the TestNG HTML report generated in the `test-output` folder after running the tests.
