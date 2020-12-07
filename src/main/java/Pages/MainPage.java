package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver= BaseSteps.getDriver();

    @FindBy (xpath = "//div[contains(text(),\"Маркет\")]//parent::a")
    private WebElement marketLink;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

   //Перейти в яндекс маркет
    public void clickMarket() throws InterruptedException {

        String parentWindow = BaseSteps.getDriver().getWindowHandle();

        String s = BaseSteps.getDriver().getTitle();
        System.out.println("Текущая страница " + s);

        marketLink.click();


        for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {
            if (!parentWindow.equals(winHandle)) {
                BaseSteps.getDriver().switchTo().window(winHandle);
                Thread.sleep(3000);
                break;
            }
        }
        System.out.println("Переключаемся в новое окно: " + BaseSteps.getDriver().getTitle());
    }
}
