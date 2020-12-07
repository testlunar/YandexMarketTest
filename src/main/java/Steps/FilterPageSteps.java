package Steps;

import Pages.FilterPage;
import Pages.YandexMarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterPageSteps {

    @Step("проверяем название заголовка на странице {0}")
    public void checkPageName(String name) throws InterruptedException {
        new FilterPage().checkPageName(name);
    }

    @Step("проставляем чекбокс производителя {0}")
    public void selectBrand(String name){
        new FilterPage().selectBrand(name);
    }


    @Step("выставляем количество элементов на странице, равное {0}")
    public void selectNumberElementsOnPage(int number) throws InterruptedException {
        new FilterPage().selectNumberElementsOnPage(number);
    }

    @Step("проверям,что количество элементов на странице, равно {0}")
    public void checkNumberElements(int number) throws InterruptedException {
        new FilterPage().checkNumberElements(number);
    }

    @Step("запоминаем название первого элемента на странице в поиске")
    public String getFirstElementDataBefore(){
        String dataBefore= new FilterPage().getFirstElementData();
        return dataBefore;
    }

    @Step("вводим в окно поиска название первого элемента")
    public void putSearchFirstElementName() throws InterruptedException {
        new FilterPage().putSearchFirstElementData();
    }

    @Step("запоминаем название первого элемента на странице после поиска по названию")
    public String getFirstElementDataAfter(){
        String dataAfter= new FilterPage().getFirstElementDataAfter();
        return dataAfter;
    }

    @Step("проверяем, что наименование и цена товара соответствует запомненному значению")
    public void compareElements(String dataBefore, String dataAfter) throws InterruptedException {
          new FilterPage().compareElements(dataBefore,dataAfter);
    }

    @Step("поле минимальная цена заполняется значением {1}")
    public void setMinPrice(String price){
        new FilterPage().setMinPrice(price);
    }

    @Step("поле максимальная цена заполняется значением {1}")
    public void setMaxPrice(String price){
        new FilterPage().setMaxPrice(price);
    }

    @Step("сравнить диапазон цен после сортировки цены от {1} до {2} ")
    public void checkPriceRange(int min,int max) throws InterruptedException {
        new FilterPage().checkPriceRange(min,max);
    }

}
