package relativeLocators;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class Relative_Locators extends Hooks {

    @Test
    public void relativeLocators() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");

        //driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@name='last_name']"))).sendKeys("Joe");

        WebElement lastName_TextField = driver.findElement(RelativeLocator.with(By.xpath("//input[@name='last_name']")));

        //above
        WebElement firstName_TextField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(lastName_TextField));

        firstName_TextField.sendKeys("Joe");
        lastName_TextField.sendKeys("Blogs");


        //below
        WebElement email_TextField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(lastName_TextField));
        email_TextField.sendKeys("joe_blogs12345@outlook.com");

        //below - locate text area element
        WebElement comments_TextField = driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(lastName_TextField));
        comments_TextField.sendKeys("test12345");

        //below - locate the Reset button
        WebElement reset_Button = driver.findElement(RelativeLocator.with(By.tagName("input")).below(comments_TextField));
        reset_Button.click();
        Thread.sleep(0);
    }

}