## Test Automation Framework
Test Automation Framework built using Selenium WebDriver, TestNG, Maven, Java 11, Log4j, ExtentReports, LambdaTest, and multiple data-driven testing libraries.

This framework is designed to support:

Cross-browser test execution
Local and cloud execution using LambdaTest
Headless browser execution
Data-driven testing using CSV, JSON, and Excel
Dynamic test data generation using Java Faker
Parallel/scalable execution through TestNG
Detailed HTML execution reports
Application and framework logging
Command-line execution using Maven
Easy integration with CI/CD pipelines such as GitHub Actions
## 🚀 About Me
Hi, This is Manasi Avachat, I have 10+ years of expirence in Automation Testing using technologies like Selenium Webdriver, RestAssured.




## Author

- [@manasi7830](https://github.com/manasi7830/Test-Automation-Framework)

- EmailAddress: manasiavachat14@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/manasi7830)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/manasi-avachat-695a4823/)




## Prerequisites

Before running this framework, ensure the following software is installed on your system:

- **Java 11**- Make sure Java is installed and JAVA_HOME environment variable is set.
- **Maven**- Ensure Maven is installed  and added to the system path

## Features

- **Data-Driven Testing**: Using OpenCSV, Appache POI,and GSon for reading test data from CSV and Excel files.
- **Cross-Browser Testing**: Supports running tests on different browsers.
- **Headless Mode**: Faster execution by running tests in headless mode.
- **Cloud Testing**: Integrated with LambadaTest to run tests on the cloud.
- **Logging**: Uses Log4j for detailed logs.
- **Reporting**: Generates detailed reports using Extent Reports.


## Technologies Used
- Java 11	
- Selenium 
- TestNG	
- Maven	
- Maven Surefire Plugin	
- parameterization
- OpenCSV	
- Gson	
- Apache POI	
- Java Faker	
- ExtentReports	
- Log4j	
## Setup Instructions

**Clone the Repository:**

```bash
    git clone https://github.com/manasi7830/Test-Automation-Framework.git

```
**Running Tests on LambdaTest:**

```bash
    mvn  test -Dbrowser=chrome -DisLambdaTest=true -DisHeadLess=false -X    

```

**Running Tests on Chrome browser on local machine in HeadLess mode:**

```bash
    mvn  test -Dbrowser=chrome -DisLambdaTest=true -DisHeadLess=true -X    

```

## Reporting 
The framework uses ExtentReports for HTML reporting.
After test execution, an HTML report is generated:

./report.html

The report provides visibility into test execution, including information such as:

Passed tests
Failed tests
Skipped tests
Test execution details
Failure information
Execution steps/log messages, depending on implementation

## Logging
The framework uses Log4j for logging.
Logs are generated under:

./logs

## Integrated the project with GitHub Actions

This automation framework is integrated with github actions.The tests will be executed at 11.30PM IST every single day.

The reports will be archieved in gh-pages branch
You can view the html reports at:
https://github.com/manasi7830/Test-Automation-Framework/report.html
