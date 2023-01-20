package handlingWindows;

import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class New_Windows extends Hooks {

    @Test
    public void newWindow() {
        driver.get("http://www.webdriveruniversity.com/");

        //Open new window and access another URL
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.automationteststore.com/");
        driver.manage().window().maximize();

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((windows.get(0)));
        System.out.println(driver.getCurrentUrl());  //webuniversity
        // przelaczam sie na 2 okno i zamykam

        driver.switchTo().window(windows.get(1));
        System.out.println(driver.getCurrentUrl());
        driver.close();

        // switch to 1 windows
        driver.switchTo().window((windows.get(0)));
        System.out.println(driver.getCurrentUrl());  //webuniversity








    }

}
