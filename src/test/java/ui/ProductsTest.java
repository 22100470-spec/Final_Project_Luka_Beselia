package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    @Description("Test Case 8: Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetail() {
        navigateToProductsPage();
        ProductsPage productsPage = new ProductsPage(driver);

        verifyAllProductsPageVisible(productsPage);
        verifyProductsListVisible(productsPage);
        viewFirstProduct(productsPage);
        verifyProductDetailsVisible(productsPage);
    }

    @Test
    @Description("Test Case 9: Search Product")
    public void searchProduct() {
        ProductsPage productsPage = new ProductsPage(driver);

        navigateToProductsPage();
        verifyAllProductsPageVisible(productsPage);

        searchForProduct(productsPage, "Blue Top");
        verifySearchedProductsVisible(productsPage);
    }

    @Step("Navigate to Products page")
    private void navigateToProductsPage() {
        // Try clicking the Products link first
        try {
            driver.findElement(By.xpath("//a[@href='/products']")).click();
        } catch (Exception e) {
            // Fallback: ignore and navigate directly if needed
        }
        // Ensure we are on the /products page
        try {
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                    .until(org.openqa.selenium.support.ui.ExpectedConditions.or(
                            org.openqa.selenium.support.ui.ExpectedConditions.urlContains("/products"),
                            org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//h2[contains(text(),'All Products')]"))
                    ));
        } catch (Exception e) {
            driver.get("https://automationexercise.com/products");
        }
    }

    @Step("Verify user is navigated to ALL PRODUCTS page")
    private void verifyAllProductsPageVisible(ProductsPage page) {
        Assert.assertTrue(page.isAllProductsVisible());
    }

    @Step("Verify products list is visible")
    private void verifyProductsListVisible(ProductsPage page) {
        Assert.assertTrue(page.isProductsListVisible());
    }

    @Step("Click on 'View Product' of first product")
    private void viewFirstProduct(ProductsPage page) {
        page.clickFirstProductView();
    }

    @Step("Verify product details are visible")
    private void verifyProductDetailsVisible(ProductsPage page) {
        Assert.assertTrue(page.isProductNameVisible());
        Assert.assertTrue(page.isProductCategoryVisible());
        Assert.assertTrue(page.isProductPriceVisible());
    }

    @Step("Enter product name '{query}' in search input and click search button")
    private void searchForProduct(ProductsPage page, String query) {
        page.enterSearchQuery(query);
        page.clickSearchButton();
    }

    @Step("Verify 'SEARCHED PRODUCTS' is visible")
    private void verifySearchedProductsVisible(ProductsPage page) {
        Assert.assertTrue(page.isSearchedProductsVisible());
    }
}