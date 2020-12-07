package Steps;

import Pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {


    @Step("выбран подпункт меню Маркет")
    public void clickMarket() throws InterruptedException {
        new MainPage().clickMarket();

    }


}
