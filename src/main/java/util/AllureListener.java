package util;

import Steps.BaseSteps;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;

public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){

        BaseSteps.takeScreenshot();
        super.testFailure(failure);
        System.out.println("Тест, к сожалению, упал!");
    }
}

