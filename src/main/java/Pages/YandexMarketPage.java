package Pages;

import Steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class YandexMarketPage {
    @FindBy(xpath = "//span[contains(text(),\"Компьютеры\")]//parent::a")
    WebElement computersLabel;

    @FindBy(xpath = "(//a[contains(text(),\"Ноутбуки\")])[2]")
    WebElement notebooks;

    @FindBy(xpath = "//a[contains(text(),\"Планшеты\")]")
    WebElement planshety;


    public YandexMarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    WebDriver driver = BaseSteps.getDriver();

    //Выбрать раздел Компьютеры
    public void selectComputers() {
        computersLabel.click();
    }

    //Выбрать раздел Ноутбуки или Планшеты
    public void selectSubMenu(String type) throws InterruptedException {
        Thread.sleep(1000);
        if (type.equals("Ноутбуки")) {
            notebooks.click();
        }
        if (type.equals("Планшеты")) {
            planshety.click();
        }
    }


}
