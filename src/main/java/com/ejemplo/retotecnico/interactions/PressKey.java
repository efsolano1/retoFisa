package com.ejemplo.retotecnico.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PressKey implements Interaction {
    private final String key;

    public PressKey(String key) {
        this.key = key;
    }

    public static PressKey withKey(String key) {
        return Tasks.instrumented(PressKey.class, key);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            WebDriver driver = ThucydidesWebDriverSupport.getDriver();

            WebElement body = driver.findElement(By.tagName("body"));
            body.click();

            Actions actions = new Actions(driver);
            actions.sendKeys(key).perform();

            System.out.println("✅ Presionada tecla: " + key);

        } catch (NoSuchSessionException e) {
            System.err.println("⚠️ Sesión de WebDriver inválida. Verifica que el navegador siga abierto.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("⚠️ Error al presionar tecla '" + key + "': " + e.getMessage());
            e.printStackTrace();
        }
    }
}
