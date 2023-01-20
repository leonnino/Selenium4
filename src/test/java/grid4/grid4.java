package grid4;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class grid4 extends Hooks {

    @Test
    public void performingActions() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/Actions/index.html");

        //Click&hold
        WebElement clickAndHold_Element = driver.findElement(By.id("click-box"));
        Actions actionProvider = new Actions(driver);
        actionProvider.clickAndHold(clickAndHold_Element).build().perform();
        actionProvider.release(clickAndHold_Element).build().perform();

        //Drag and drop
        WebElement draggable_Element = driver.findElement(By.id("draggable"));
        WebElement dropHere_Element = driver.findElement(By.id("droppable"));
        Thread.sleep(1000);
        actionProvider.moveToElement(draggable_Element).clickAndHold()
                .moveToElement(dropHere_Element).release().build().perform();
        Thread.sleep(1000);

        //double click

        WebElement doubleClick_Element = driver.findElement(By.id("double-click"));
        actionProvider.doubleClick(doubleClick_Element).release().build().perform();
        Thread.sleep(10000);



    }
}
