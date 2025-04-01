# REST Assured API Test Framework
[[Java Version](https://img.shields.io/badge/Java-8-blue.svg)](https://www.oracle.com/java/)]
[[TestNG](https://img.shields.io/badge/TestNG-7.8.0-red.svg)](https://testng.org)]
[[RestAssured](https://img.shields.io/badge/RestAssured-5.3.1-green.svg)](https://rest-assured.io)]

Automated API testing framework for e-commerce endpoints using **RestAssured** and **TestNG**, with Maven for dependency management
---

## Technologies Used
- **Java 8** (JRE System Library)
- **TestNG** - Test framework
- **RestAssured** - API testing library
- **Maven** - Dependency management

---

## Setup Instructions
### Prerequisites:
- JDK 8
- Maven 3.6+

### Clone the repository:
git clone https://github.com/yourusername/ecommerceAPITest.git

### Build the project:
mvn clean install

### Running Tests:
Run all tests: mvn test
Run specific test groups: mvn test -Dgroups=products

### Dependencies (pom.xml): 
### <dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.1</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
    </dependency>
### </dependencies>


### Contributors 
Manish Khadka


### This matches:
Java 8 requirement from your JRE System Library  
Package structure shown in the image  
Maven-based project organization  
TestNG test runner configuration