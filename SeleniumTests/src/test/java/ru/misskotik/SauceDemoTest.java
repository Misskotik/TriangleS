package ru.misskotik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static ru.misskotik.AbstractTest.getDriver;
public class SauceDemoTest extends AbstractTest {

    @Test
    void addToCartTest() {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.saucedemo.com/cart.html"));
      Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));


//        Actions addItem = new Actions(getDriver());
//        addItem.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")))
//                .click(getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")))
//                .build()
//                .perform();
//
//        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));
    }


    @Test
            void removeTest ()
    {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));
        getDriver().findElement(By.id("remove-sauce-labs-backpack")).click();
        Assertions.assertFalse(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));


   }
    @Test
    void continueShoppingTest ()
    {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        getDriver().findElement(By.id("remove-sauce-labs-backpack")).click();
        getDriver().findElement(By.id("continue-shopping")).click();
        Assertions.assertTrue(true);

    }
    @Test
    void startCheckoutTest () {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        getDriver().findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("3"));
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        getDriver().findElement(By.id("checkout")).click();
        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='header_container']/div[2]/span")).getText().equals("CHECKOUT: YOUR INFORMATION"));

    }

    @Test
    void checkoutFormTest () {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        getDriver().findElement(By.id("checkout")).click();
        getDriver().findElement(By.id("first-name")).sendKeys("Alex");
        getDriver().findElement(By.id("last-name")).sendKeys("Davon");
        getDriver().findElement(By.id("postal-code")).sendKeys("190000");
        getDriver().findElement(By.id("continue")).click();
        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='header_container']/div[2]/span")).getText().equals("CHECKOUT: OVERVIEW"));

    }

    @Test
    void finishTest () {
        getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        getDriver().findElement(By.id("checkout")).click();
        getDriver().findElement(By.id("first-name")).sendKeys("Alex");
        getDriver().findElement(By.id("last-name")).sendKeys("Davon");
        getDriver().findElement(By.id("postal-code")).sendKeys("190000");
        getDriver().findElement(By.id("continue")).click();
        getDriver().findElement(By.id("finish")).click();
        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='checkout_complete_container']/h2")).getText().equals("THANK YOU FOR YOUR ORDER"));

    }

}


