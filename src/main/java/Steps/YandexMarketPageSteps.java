package Steps;

import Pages.MainPage;
import Pages.YandexMarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketPageSteps {

    @Step("выбрана категория Компьютеры")
    public void selectComputers() throws InterruptedException {
        new YandexMarketPage().selectComputers();
    }

    @Step("выбран подкатегория {0}")
    public void selectSubMenu(String menuItem) throws InterruptedException {
        new YandexMarketPage().selectSubMenu(menuItem);
    }


}
