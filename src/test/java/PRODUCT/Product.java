package PRODUCT;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {


    @Test
    public void ProductAddDelete()  {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.trendyol.com";
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver,10);
        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();


        WebElement genderPopup = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        genderPopup.click();


        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#accountBtn"))));
        navBarLogin.click();

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login email']")));
        email.sendKeys("tugce.cancel@gmail.com");

        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login-password']")));
        password.sendKeys("Karpuzkavun1236");


        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@type,'sub')]")));
        loginBtn.click();

        //search kutucuğuna çanta kelimesini yazar
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='search-box']")));
        search.sendKeys("çanta");
        search.sendKeys(Keys.ENTER);

        //ürüne tıklar
        WebElement urun = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/a/div[1]/div/img")));
        urun.click();

        //tıklanan ürünü sepete ekler
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "sepeteEkle");
        WebElement sepeteEkle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='add-to-bs-tx']")));
        sepeteEkle.click();

        //sepetime girer
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("window.scrollBy(0,-350)", "sepetim");
        WebElement sepetim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon navigation-icon-basket']")));
        sepetim.click();



        //ürünü sepetten siler
        WebElement sepettenSil = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='i-trash']")));
        sepettenSil.click();
        WebElement silBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn-item btn-remove']")));
       ////*[@class='btn-item btn-remove']

        silBtn.click();
        System.out.print("Pass");

    }

}
