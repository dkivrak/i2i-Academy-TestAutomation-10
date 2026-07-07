# i2i Academy Test Automation 

This project was developed for the i2i Academy Test Automation assignment. The main goal of the project is to gain practical experience with UI test automation, API automation, and performance testing by using Java, Selenium WebDriver, REST Assured, Nginx, and Apache JMeter.

## Project Overview

The project contains three main parts:

1. UI Login Automation with Selenium WebDriver
2. API Automation with REST Assured
3. Performance and Stress Testing with Nginx and Apache JMeter

The Selenium and REST Assured tests are implemented in a Java Maven project. The performance testing part uses a local Nginx server and Apache JMeter to simulate concurrent user load.

## Technologies Used

- Java 17
- Maven
- JUnit 5
- Selenium WebDriver
- REST Assured
- JSONPath
- Jackson Databind
- Docker
- Nginx
- Apache JMeter

## Project Structure

i2i-Academy-TestAutomation-10/
├── pom.xml
├── nginx/
│ └── html/
│ ├── index.html
│ └── api.json
└── src/
└── test/
└── java/
└── com/
└── i2i/
└── testautomation/
├── SeleniumLoginTest.java
└── ApiAutomationTest.java

## Selenium UI Login Automation

The Selenium part automates the login process of the SauceDemo demo e-commerce website.

The test scenario includes:

- Opening the Chrome browser
- Navigating to SauceDemo
- Locating the username field, password field, and login button
- Entering test credentials
- Clicking the login button
- Verifying that the login was successful by checking the redirected inventory page URL

Demo website:

```bash
https://www.saucedemo.com/
```

Test credentials:

```text
Username: standard_user
Password: secret_sauce
```

## REST Assured API Automation

The API automation part uses REST Assured to test HTTP requests against the JSONPlaceholder demo API.

The implemented API tests include:

- GET request test
- POST request test
- HTTP status code validation
- Response time validation
- Response body field validation

Demo API:

```bash
https://jsonplaceholder.typicode.com
```

The GET test retrieves a post by ID and validates fields such as `id` and `userId`.

The POST test sends a JSON request body and validates that the API returns `201 Created` with the expected response body values.

## Performance and Stress Testing

The performance testing part uses Docker, Nginx, and Apache JMeter.

A local Nginx server was configured to serve:

- A simple HTML page
- A dummy JSON API endpoint

Local Nginx URLs:

```text
http://localhost:8080
http://localhost:8080/api.json
```

The dummy API endpoint returns a mock JSON response and is used as the target endpoint for Apache JMeter.

## JMeter Test Configuration

The Apache JMeter test plan includes:

- Thread Group
- HTTP Request Sampler
- View Results Tree
- Summary Report
- Aggregate Report

Thread Group configuration:

```text
Number of Threads: 100
Ramp-up Period: 10 seconds
Loop Count: 10
```

HTTP Request configuration:

```
Method: GET
Server Name: localhost
Port: 8080
Path: /api.json
```

The stress test was executed successfully, and the reports showed successful responses with `0.00%` error rate.

## How to Run the Java Tests

Clone the repository:

```bash
git clone https://github.com/dkivrak/i2i-Academy-TestAutomation-10.git
cd i2i-Academy-TestAutomation-10
```

Run all Maven tests:

```bash
mvn test
```

Run only the API automation tests:

```bash
mvn -Dtest=ApiAutomationTest test
```

Run only the Selenium login test:

```bash
mvn -Dtest=SeleniumLoginTest test
```

## How to Run the Nginx Test Server

Start the Nginx container:

```bash
docker run --name i2i-nginx-test -p 8080:80 -v $(pwd)/nginx/html:/usr/share/nginx/html:ro -d nginx
```

Check if the container is running:

```bash
docker ps
```

Open the test page:

```bash
http://localhost:8080
```

Open the dummy API endpoint:

```bash
http://localhost:8080/api.json
```

Stop and remove the container after testing:

```bash
docker stop i2i-nginx-test
docker rm i2i-nginx-test
```

## Notes

- The project source code and configuration files are included in this repository.
- Assignment documents, screenshots, and final submission files are not included in the repository.
- The final documentation and screenshots are submitted separately through Google Classroom.
