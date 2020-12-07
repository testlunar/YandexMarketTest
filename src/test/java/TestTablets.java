import Steps.BaseSteps;
import Steps.FilterPageSteps;
import Steps.MainPageSteps;
import Steps.YandexMarketPageSteps;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Diana on 06.12.2020.
 */

public class TestTablets extends BaseSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    YandexMarketPageSteps yandexMarketPageSteps = new YandexMarketPageSteps();
    FilterPageSteps filterPageSteps = new FilterPageSteps();

    @Title("ЯндексМаркет, раздел Планшеты")
    @Description("Выбираем на Яндекс Маркете раздел Планшеты, 2 бренда Apple,Huawei")
    @Features("Настраиваем фильтр по цене, проверяем элементы на соответствие фильтру")
    @Test

    public void Test() throws InterruptedException {

        mainPageSteps.clickMarket();
        yandexMarketPageSteps.selectComputers();
        yandexMarketPageSteps.selectSubMenu("Планшеты");
        filterPageSteps.checkPageName("Планшеты");
        filterPageSteps.selectBrand("Производитель Apple");
        filterPageSteps.selectBrand("Производитель HUAWEI");
        filterPageSteps.setMinPrice("20000");
        filterPageSteps.setMaxPrice("25000");
        filterPageSteps.checkPriceRange(20000,25000);



    }
}
