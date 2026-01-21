# qa-automation-framework

## Overview
This project is a Java-based QA automation framework designed to validate both API and UI functionality.  
It demonstrates industry-standard practices such as Page Object Model (POM), reusable test utilities, and clear separation of concerns.  
The framework includes positive and negative test scenarios, along with automated failure diagnostics.

## Tech Stack
- Java 17  
- Maven  
- JUnit 5  
- Selenium WebDriver  
- REST Assured  
- Java Faker  
- WebDriverManager  

## Project Structure
```
src
└── test
├── java
│   ├── com.paola.tests.api        # API test cases
│   ├── com.paola.tests.ui         # UI test cases
│   ├── com.paola.pages            # Page Object classes
│   ├── com.paola.utilities        # Driver, base tests, helpers, extensions
│   └── com.paola.pojo             # Request/response POJOs
└── resources
```
## API Testing Overview
The API tests validate REST endpoints using REST Assured.  
Test cases cover common HTTP operations such as GET and POST, including both positive and negative scenarios.  
Request and response payloads are modeled using POJO classes to support serialization and deserialization, improving readability and maintainability.

## UI Testing Overview
UI tests are implemented using Selenium WebDriver and follow the Page Object Model (POM) design pattern.  
Test cases validate user journeys and page-specific behavior using explicit waits to ensure stability and reliability.  
Page objects encapsulate element locators and interaction logic, keeping test methods clean and readable.

## How to Run Tests
1. Clone the repository  
2. Open the project in an IDE that supports Maven (IntelliJ IDEA recommended)  
3. Ensure Java 17 is configured  
4. Run tests using Maven:
```bash
mvn test
```

## Reporting & Screenshots
UI tests automatically capture screenshots when a test fails.  
Screenshots are saved under the `target/screenshots` directory to assist with debugging and failure analysis.  
This behavior is implemented using a JUnit 5 extension, ensuring all UI tests inherit failure diagnostics without duplicating code.

