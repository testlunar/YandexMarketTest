import Pages.FilterPage;
import Pages.MainPage;
import Pages.YandexMarketPage;
import Steps.BaseSteps;
import Steps.FilterPageSteps;
import Steps.MainPageSteps;
import Steps.YandexMarketPageSteps;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Diana on 06.12.2020.
 */

public class TestNotebooks extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    YandexMarketPageSteps yandexMarketPageSteps = new YandexMarketPageSteps();
    FilterPageSteps filterPageSteps = new FilterPageSteps();


    @Title("ЯндексМаркет, раздел Ноутбуки")
    @Description("Выбираем на Яндекс Маркете раздел Ноутбуки, 2 бренда HP,Lenovo")
    @Features("проверяем количество элементов и название 1го элемента на странице")
    @Test
    public void Test() throws InterruptedException {

        //Перейти в яндекс маркет
        mainPageSteps.clickMarket();

        //Выбрать раздел Компьютеры
        yandexMarketPageSteps.selectComputers();

        //Выбрать раздел Ноутбуки
        yandexMarketPageSteps.selectSubMenu("Ноутбуки");

        //Проверить что на странице заголовок содержит текст «Ноутбуки»
        filterPageSteps.checkPageName("Ноутбуки");

        //Выбрать фильтр по производителям HP и Lenovo
        filterPageSteps.selectBrand("Производитель HP");
        filterPageSteps.selectBrand("Производитель Lenovo");

        //Выбрать опцию «Показывать по 12» внизу страницы
        filterPageSteps.selectNumberElementsOnPage(12);

        //Проверить, что элементов на странице не больше 12.
        filterPageSteps.checkNumberElements(12);

        //Запомнить первый элемент в списке.
        String dataBefore = filterPageSteps.getFirstElementDataBefore();

        //В поисковую строку ввести запомненное значение.
        filterPageSteps.putSearchFirstElementName();

        //Проверить, что наименование и сумма найденного товара соответствует запомненному значению.
        String dataAfter = filterPageSteps.getFirstElementDataAfter();
        filterPageSteps.compareElements(dataBefore, dataAfter);


    }
}
