# Final_Project_Luka_Beselia

1) გუნდის წევრები:
   ლუკა ბესელია (22100470@ibsu.edu.ge) - სოლო პროექტი

2) შერჩეული 10 UI და 10 API ტესტი:
     ### UI  (https://automationexercise.com/test_cases)

    1. **Register User** – (`RegistrationTest`)
    2. **Login User with correct email and password** –  (`LoginTest`)
    3. **Login User with incorrect email and password** –  (`LoginTest`)
    4. **Logout User** – (`LoginTest`)
    5. **Register User with existing email** –  (`RegistrationTest`)
    6. **Contact Us Form** –  (`ContactUsTest`)
    7. **Verify Test Cases Page** – (`TestCasesPageTest`)
    8. **Verify All Products and product detail page** – (`ProductsTest`)
    9. **Search Product** – (`ProductsTest`)
    10. **Verify Subscription in home page** – (`SubscriptionTest`)
    
     ###  API  (https://automationexercise.com/api_list)
    
    1. **API 1: Get All Products List** – (`ProductsApiTest`)
    2. **API 2: POST To All Products List** – (`ProductsApiTest`)
    3. **API 3: Get All Brands List** – (`BrandsApiTest`)
    4. **API 4: PUT To All Brands List** – (`BrandsApiTest`)
    5. **API 5: POST To Search Product** – (`SearchProductApiTest`)
    6. **API 6: POST To Search Product without search_product parameter** – (`SearchProductApiTest`)
    7. **API 7: POST To Verify Login with valid details** – (`LoginApiTest`)
    8. **API 8: POST To Verify Login without email parameter** – (`LoginApiTest`)
    9. **API 9: DELETE To Verify Login** – (`LoginApiTest`)
    10. **API 10: POST To Verify Login with invalid details** – (`LoginApiTest`)

3) Automation Stack (მონიშნული რომ იყო ინსტრუქციებში როგორც mandatory):

- **Language**: Java
- **Test Runner**: TestNG
- **UI Automation**: Selenium WebDriver
- **API Automation**: RestAssured
- **Build Tool**: Maven
- **Reporting**: Allure Reports
- **Design Pattern**: Page Object Model (POM)

4) სტურქტურა:
   
- **src/main/java/pages** – Page Objects for UI
- **src/test/java/ui** – UI test classes
- **src/test/java/api** – API test classes
- **pom.xml** – Maven configuration
- **testng.xml** – TestNG suite (separate UI and API tests)

5) ინსტრუქციები:
    1) გაუშვით ყველა ტესტი (UI + API)
    2) mvn clean test
    3) allure generate allure-results -o allure-report --clean
    4) allure open allure-report
     
   
