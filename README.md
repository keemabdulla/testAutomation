<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">DemoBlaze Test Automation</h3>
  <p align="center">
    Built using Selenium Java - Maven TestNG
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#prerequisites">Prerequisites</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#running-the-tests">Running the Tests</a></li>
    <li><a href="#project-structure">Project Structure</a></li>
    <li><a href="#reports">Reports</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This project's purpose is to showcase common best practices and techniques in Web Test Automation using Selenium Java - Maven TestNG.

### Built With

- Selenium WebDriver https://www.selenium.dev/
- TestNG Framework https://testng.org/

<!-- GETTING STARTED -->
## Getting Started

Clone the project:

```bash
git clone https://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@github.com/keemabdulla/testAutomation
```

### Prerequisites

- Latest Chrome Browser
- Maven v3.9.6
- Jdk Java v20.0.2

After cloning the project, open terminal (make sure that you're in the project directory) install all the maven dependencies

```bash
mvn dependency:resolve
```

### Running the Tests

From IDE terminal or PowerShell, make sure that you're in the project directory

```bash
mvn clean test
```
or

Right-click on testng.xml and select "Run testng.xml" in your preferred IDE.

### Project Structure

- src
  - test
    - java
    - resources
- target
- pom.xml
- testng.xml

### Reports

Reports are auto-generated using ExtentReport Dependency

After each test execution, an HTML file will be generated in the Automation Reports directory.

### Contact

Email: alakeemabdulla@gmail.com

Project Link: https://github.com/keemabdulla/testAutomation


