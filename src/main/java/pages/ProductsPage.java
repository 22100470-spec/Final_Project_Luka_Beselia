package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By allProductsText = By.xpath("//h2[@class='title text-center']");
    private By productsList = By.className("features_items");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsText = By.xpath("//h2[text()='Searched Products']");
    private By firstProductViewLink = By.xpath("(//a[contains(@href,'/product_details/')])[1]");
    private By productName = By.xpath("//div[@class='product-information']//h2");
    private By productCategory = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    private By productPrice = By.xpath("//div[@class='product-information']//span//span");
    private By productAvailability = By.xpath("//div[@class='product-information']//p[contains(text(),'Availability')]");
    private By productCondition = By.xpath("//div[@class='product-information']//p[contains(text(),'Condition')]");
    private By productBrand = By.xpath("//div[@class='product-information']//p[contains(text(),'Brand')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAllProductsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsText)).isDisplayed();
    }

    public boolean isProductsListVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsList)).isDisplayed();
    }

    public void clickFirstProductView() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstProductViewLink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isProductNameVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed();
    }

    public boolean isProductCategoryVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory)).isDisplayed();
    }

    public boolean isProductPriceVisible() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isProductAvailabilityVisible() {
        return driver.findElement(productAvailability).isDisplayed();
    }

    public boolean isProductConditionVisible() {
        return driver.findElement(productCondition).isDisplayed();
    }

    public boolean isProductBrandVisible() {
        return driver.findElement(productBrand).isDisplayed();
    }

    public void enterSearchQuery(String query) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
        searchBox.sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isSearchedProductsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsText)).isDisplayed();
    }
}