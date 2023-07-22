package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepImplementation extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    @Step("<time> saniye bekle")
    public void DelayTo(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1 + time);
    }

    @Step("ID ile <element> tikla")
    public void clickToByID(String element) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
        driver.findElement(By.id(element)).click();

    }

    @Step("CSS ile <element> tikla")
    public void clickToByCSS(String element) {
        wait.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector(element)));
        driver.findElement(new By.ByCssSelector(element)).click();
    }

    @Step("XPATH ile <element> tikla")
    public void clickToByXpath(String element) {
        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath(element)));
        driver.findElement(new By.ByXPath(element)).click();
    }

    @Step("CSS ile <element> bul ve <message> girin")
    public void sendToByCSS(String element, String message) {
        wait.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector(element)));
        driver.findElement(new By.ByCssSelector(element)).sendKeys(message);
    }

    @Step("Istenilen Esyayi Bulma")
    public void FindProduct() {
        List<WebElement> product = driver.findElements(By.xpath("//*[contains(text(),'Bic Evolution')]"));
        int size = product.size();
        System.out.println("Urunlerin sayisi = " + size);
        if (size > 0) {
            System.out.println("Test Basarilidir");
        } else {
            System.out.println("Test Basarisizdir");
        }

    }


}