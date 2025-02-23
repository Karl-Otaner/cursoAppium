package br.com.carlos.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

        private static AndroidDriver<MobileElement> driver;

        public static AndroidDriver<MobileElement> getDriver() {
            if (driver == null){
                createDriver();
            }
            return driver;
        }

        private static void createDriver() {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "Nexus5-teste");
            desiredCapabilities.setCapability("udid", "emulator-5554");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\carlos.silva\\WS\\CursoTesteAndroidAppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");

            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        public static void killDriver(){
            if (driver != null){
                driver.quit();
                driver=null;
            }
        }
    }
