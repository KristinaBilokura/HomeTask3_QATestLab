
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class B {
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(String.valueOf(B.class));

    @BeforeClass
    public static void getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void GmailTest() {

        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=" +
                "AdminLogin&token=d251f363cceb5a849cb7330938c64dea";
        By loginInput = By.id("email");
        By passwordInput = By.id("passwd");
        By submitLoginButton = By.name("submitLogin");
        driver.get(url);
        driver.findElement(loginInput).sendKeys("webinar.test@gmail.com");
        driver.findElement(passwordInput).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(submitLoginButton).submit();

        driver.findElement(By.id("tab-AdminDashboard")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminParentOrders")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());

        driver.findElement(By.id("subtab-AdminParentCustomer")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminParentCustomerThreads")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminStats")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminParentThemes")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminParentShipping")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminParentPayment")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminInternational")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-ShopParameters")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminAdvancedParameters")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='page-title']")).getText());
        driver.findElement(By.id("subtab-AdminCatalog")).click();
        log.info(driver.findElement(By.xpath("//h2[@class='title']")).getText());
        driver.findElement(By.xpath("//li[@data-submenu='42']")).click();
        String caption = driver.findElement(By.xpath("//h2[@class='title']")).getText();
        log.info(caption);


        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='title']")).getText(),caption);
    }

    @AfterClass
    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
