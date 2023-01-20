package waits;

import base.Hooks;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Fluent_Wait extends Hooks {

    @Test
    public void fluentWait(){

        driver.get("https://www.automationteststore.com/");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500)).
                ignoring(NoSuchElementException.class);


    }
}
