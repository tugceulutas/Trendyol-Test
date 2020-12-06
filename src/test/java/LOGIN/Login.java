package LOGIN;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    @Test
    public void LoginPage() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.trendyol.com";
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();

        //reklam kapat
        WebElement genderPopup = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        genderPopup.click();

        //Giriş yap navbarda görünene kadar bekler ve tıklar
        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#accountBtn"))));
        navBarLogin.click();


        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login email']")));
        email.sendKeys("tugce.cancel@gmail.com");

        //Password textbox'ı için veri gönderir
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login-password']")));
        password.sendKeys("135246Aa");


        //Giriş Yap Butonuna Tıklar
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@type,'sub')]")));
        loginBtn.click();


    }
}
