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

        //Перейти в яндекс маркет
        mainPageSteps.clickMarket();

        //Выбрать раздел Компьютеры
        yandexMarketPageSteps.selectComputers();

        //Выбрать раздел Планшеты
        yandexMarketPageSteps.selectSubMenu("Планшеты");

        //Проверить что на странице отображается заголовок «Планшеты»
        filterPageSteps.checkPageName("Планшеты");

        //Выбрать фильтр по производителям Apple и HUAWEI
        filterPageSteps.selectBrand("Производитель Apple");
        filterPageSteps.selectBrand("Производитель HUAWEI");

        //Задать параметр поиска от 20000 рублей.
        filterPageSteps.setMinPrice("20000");

        //Задать параметр поиска до 25000 рублей.
        filterPageSteps.setMaxPrice("25000");

        //Проверить что цены в таблице в интервале 20000  – 25000 рублей
        filterPageSteps.checkPriceRange(20000,25000);



    }
}
