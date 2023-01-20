package chromeDevTools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v107.network.Network.loadingFailed;

//import static org.openqa.selenium.devtools.v91.network.Network.loadingFailed;

public class Emulate_Network_Conditions extends Hooks {

    public static void emulateNetwork_Online(DevTools devTools) {
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));

        //CELLULAR2G
        devTools.send(Network.emulateNetworkConditions(false, 100, 200000, 100000, Optional.of(ConnectionType.CELLULAR2G)));
    }

    public static void emulateNetwork_Offline(DevTools devTools) {
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(true, 100, 200000, 100000, Optional.of(ConnectionType.ETHERNET)));
        devTools.addListener(loadingFailed(), loadingFailed -> System.out.println("Error Text: " + loadingFailed.getErrorText()));
    }


    @Test
    public void emulateNetworkConditions() {

        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();


        emulateNetwork_Online(devTools);

        //emulateNetwork_Offline(devTools);

        long startTime = System.currentTimeMillis();
        driver.get("http://www.automationteststore.com/");
        long endTime = System.currentTimeMillis();

        System.out.println("Page loaded in: " + (endTime - startTime));

        //CELLULAR2G:
        //Page loaded in: 7291
        //Page loaded in: 7181

        //WIFI:
        //Page loaded in: 6803
    }
}
