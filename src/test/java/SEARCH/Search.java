package SEARCH;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {

    @Test

    public void SearchTest() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.trendyol.com";
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();

        WebElement genderPopup = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        genderPopup.click();

        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#accountBtn"))));
        navBarLogin.click();

        //E-mail textbox'ı için veri gönderir
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login email']")));
        email.sendKeys("tugce.cancel@gmail.com");

        //Password textbox'ı için veri gönderir
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login-password']")));
        password.sendKeys("135246Aa");

        //search kutucuğuna çanta kelimesini yazar
        WebElement search = driver.findElement(By.xpath("//input[@class='search-box']"));
        search.sendKeys("çanta");
        search.sendKeys(Keys.ENTER);

    }
}
