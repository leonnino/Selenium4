package chromeDev_Tools;

import base.Hooks;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

public class Network_Intercept extends Hooks {

    @Test
    public void networkIntercept() {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of(".png", ".jpg")));

        driver.get("https://www.automationteststore.com/");
        devTools.send(Network.disable());
    }
}
