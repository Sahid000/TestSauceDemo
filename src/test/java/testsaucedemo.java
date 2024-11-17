import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testsaucedemo {

    //Main Class
    public static WebDriver driver;
    static String BaseURL = "https://www.saucedemo.com/";


    @BeforeTest
    public static void Websetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",  "D:\\Software Testing All\\Selenium_Java\\New chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    //Login
    public static void Login() throws Exception {
        driver.findElement(By.xpath("//input[@id='user-name']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    //Logout
    public static void Logout()throws Exception {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public static void Test_Closure() {
        driver.quit();
    }

}
