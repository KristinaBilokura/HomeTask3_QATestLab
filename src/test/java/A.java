import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class A {
    private static WebDriver driver;
    @BeforeClass
    public static void getDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void GmailTest()  {
        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=" +
                "AdminLogin&token=d251f363cceb5a849cb7330938c64dea";
        By loginInput = By.id("email");
        By passwordInput = By.id("passwd");
        By submitLoginButton = By.name("submitLogin");
        driver.get(url);
        driver.findElement(loginInput).sendKeys("webinar.test@gmail.com");
        driver.findElement(passwordInput).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(submitLoginButton).submit();
        By userPictogram = By.xpath("//li[@id='employee_infos']/a");
        driver.findElement(userPictogram).click();
        By exit = By.id("header_logout");
        driver.findElement(exit).click();

    }
    @AfterClass
    public static void quit(){
        if (driver != null) {
            driver.quit();
        }
    }
}
