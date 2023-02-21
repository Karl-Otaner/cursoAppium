package br.com.carlos.cursoAppium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormularioTeste {

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Nexus5-teste");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\carlos.silva\\WS\\CursoTesteAndroidAppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");


        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar formulario
        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        // for (MobileElement elemento: elementosEncontrados){
        //  System.out.println(elemento.getText());
        //}
        elementosEncontrados.get(1).click();
        //Escrever nome
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Carlos");

        //Checar nome escrito
        String text = campoNome.getText();
        Assert.assertEquals("Carlos", text);


        driver.quit();

    }
}
