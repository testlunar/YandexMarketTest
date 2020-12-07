package Pages;

import Steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FilterPage {

    @FindBy(xpath = "//div[@data-apiary-widget-name=\"@MarketNode/SearchHeadline\"]//child::h1")
    WebElement Heading;

    @FindBy(xpath = "//button[contains(@id,'dropdown-control')]")
    WebElement elementsOnPage;

    @FindBy(xpath = "(//h3/a)[1]")
    WebElement firstElementName;

    @FindBy(xpath = "//input[@name=\"Цена от\"]")
    WebElement minPrice;

    @FindBy(xpath = "//input[@name=\"Цена до\"]")
    WebElement maxPrice;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement search;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@data-zone-name=\"price\"])[1]//child::span[1]//child::span")
    WebElement firstElementPrice;

    @FindBy(xpath = "//span[contains(text(),\"Сортировать:\")]//following-sibling::button[contains(text(),\"по цене\")]")
    WebElement sortElements;


    public FilterPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    WebDriver driver = BaseSteps.getDriver();


    public void checkPageName(String expHeading) throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(Heading));
        String actualHeading = Heading.getText();
        Assert.assertTrue(actualHeading.equals(expHeading));
        System.out.println("Название на странице корректное.");
    }

    public void selectBrand(String brand) {
        WebElement searchBrand = driver.findElement(By.xpath("//input[@name='" + brand + "']/parent::label/div"));
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView();", searchBrand);
        searchBrand.click();
    }


    public void selectNumberElementsOnPage(int number) throws InterruptedException {
        Thread.sleep(1000);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        elementsOnPage.click();
        Thread.sleep(1000);
        WebElement link = driver.findElement(By.xpath("//button[contains(@id,'dropdown-control')]//following-sibling::div//child::button[contains(text(),'" + number + "')]"));
        wait.until(ExpectedConditions.visibilityOf(link));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }


    public void checkNumberElements(int num) throws InterruptedException {
        Thread.sleep(1000);
        int list = driver.findElements(By.xpath("//article")).size();
        assertThat(list, equalTo(num));
        System.out.println("Количество элементов на странице " + list);

    }

    public String getFirstElementData() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(firstElementName));
        String firstElementName1 = firstElementName.getText();
        String firstElementPrice1 = firstElementPrice.getText();
        System.out.println("Название первого элемента на странице: " + firstElementName1 + ", цена - " + firstElementPrice1);
        return firstElementName1 + firstElementPrice1;
    }


    public String getFirstElementDataAfter() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(firstElementName));
        String secondElement1 = firstElementName.getText();
        String secondElementPrice2 = firstElementPrice.getText();
        System.out.println("Название первого элемента на странице после повторного поиска: " + secondElement1 + ", цена - " + secondElementPrice2);
        return secondElement1 + secondElementPrice2;
    }


    public void putSearchFirstElementData() throws InterruptedException {
        search.click();
        Thread.sleep(1000);
        search.sendKeys(firstElementName.getText());
        searchButton.click();
    }


    public void compareElements(String nameBefore, String nameAfter) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(nameBefore.equals(nameAfter));
        System.out.println("Названия элементов после повторного поиска совпадают.");
    }


    public void setMinPrice(String minprice) {
        minPrice.click();
        minPrice.sendKeys(minprice);

    }

    public void setMaxPrice(String maxprice) {
        maxPrice.click();
        maxPrice.sendKeys(maxprice);
    }

    public void checkPriceRange(int minprice, int maxprice) throws InterruptedException {
        Thread.sleep(1500);

        String firsElementPriceOnPage = firstElementPrice.getText();
        int lastElement = driver.findElements(By.xpath("//article")).size();
        String lastElementPriceOnPage = driver.findElement(By.xpath("(//div[@data-zone-name=\"price\"])[" + lastElement + "]//child::span[1]//child::span")).getText();

        String min2 = firsElementPriceOnPage.replaceAll(" ", "");
        String max2 = lastElementPriceOnPage.replaceAll(" ", "");
        int minOnPage = Integer.parseInt(min2);
        int maxOnPage = Integer.parseInt(max2);

        sortElements.click();
        Thread.sleep(1000);

        comparePrices(minprice, minOnPage, maxprice, maxOnPage);
        Thread.sleep(1000);
    }

    public void comparePrices(int minprice, int minpriceOnPage, int maxprice, int maxpriceOnPage) throws InterruptedException {
        Thread.sleep(1000);
        if (minpriceOnPage > minprice && maxpriceOnPage < maxprice) {
            System.out.println(String.format("Цена 1го элемента на странице = %d, цена последнего элемента = %d. Они входят в диапазон сортировки от %d до %d.", minpriceOnPage, maxpriceOnPage, minprice, maxprice));
            Thread.sleep(1000);
        }
    }
}
