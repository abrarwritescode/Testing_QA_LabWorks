import org.openqa.selenium.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTest {
    static WebDriver driver;
    @BeforeAll
    public static void initializeSEL(){
        System.setProperty("webdriver.chrome.driver","D:\\IUT\\IUT\\SEM-6\\Testing Lab\\lab-7\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();

    }

    @Test
    public void testsort() {
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Name (A - Z)']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Price (Low - High)']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Name (Z - A)']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Price (High - Low)']")).click();
        }
    }

   @Test
    public void checkbox() {
        driver.get("https://practicesoftwaretesting.com/");
       JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.cssSelector("*[data-test=\"category-01HW0JQVGHKZMDZ3KX1CQE5TEP\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"brand-01HW0JQVG8KX6N1TJGABMWFNDJ\"]")).click();
    }

    @Test
    public void searchBar(){
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"search-query\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"search-query\"]")).sendKeys("Combination Pliers");
        driver.findElement(By.cssSelector("*[data-test=\"search-query\"]")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test=\"search_completed\"]")));

        String result=driver.findElement(By.cssSelector("[data-test=\"search_completed\"]")).getText();
        assertEquals("Combination Pliers\n" +
                "$14.15", result);
    }
    @Test
    public void pricerange() {
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(796, 544));
        {
            WebElement element = driver.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".ngx-slider-full-bar"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".ngx-slider-full-bar"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".ngx-slider-pointer-max")).click();
    }

    @Test
    public void testContactPage() {
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"nav-contact\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).sendKeys("Abrar");
        driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).sendKeys("Mahmud");
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("abrar@iut-dhaka.com");
        driver.findElement(By.cssSelector("*[data-test=\"subject\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"subject\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Webmaster']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"message\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"message\"]")).sendKeys(
                "ok,\n" +
                        "bye\n"+
                        "now.... jhgvusdbb gjhjkhbfrewiugbui bjkjkearfbgui uibjk jmkn bg\n");
        driver.findElement(By.cssSelector(".row:nth-child(2)")).click();
        driver.findElement(By.cssSelector("*[data-test=\"contact-submit\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/app-root/div/app-contact/div/div/div/div"), "Thanks for your message! We will contact you shortly."));

        String message = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/div/div/div")).getText();

        assertEquals("Thanks for your message! We will contact you shortly.", message);
    }
    @Test
    public void Login() {
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")));
        driver.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.id("password")).sendKeys("welcome01");
        driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
    }

    @Test
    public void productDetailsPageTest(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.manage().window().setSize(new Dimension(752, 809));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-home\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"nav-home\"]")).click();
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"increase-quantity\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector(".fa-minus")).click();
        driver.findElement(By.cssSelector(".fa-minus")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-favorites\"]")).click();
    }

   


   /* @Test
    public void Test1(){
        chrome.get("https://demoqa.com/text-box");

        chrome.findElement(By.id("userName")).sendKeys("hello");
        chrome.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
        chrome.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("abcde");
        JavascriptExecutor js = (JavascriptExecutor) chrome;

        js.executeScript("window.scrollBy(0,400)","");
        chrome.findElement(By.id("submit")).click();

        String name=chrome.findElement(By.id("name")).getText();
        assertTrue(name.contains("hello"));


    }
    @Test
    public void test2(){

        chrome.navigate().to("https://demoqa.com/checkbox");
        chrome.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]")).click();
        JavascriptExecutor js=(JavascriptExecutor) chrome;

        js.executeScript("window.scrollBy(0,400)","");

        chrome.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]")).click();
        //*[@id="tree-node"]/div/button[1]



       // chrome.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label")).click();

        String result= chrome.findElement(By.id("result")).getText();
        assertTrue(result.contains("General"));
    }
//*[@id="tree-node"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]/svg
    //*[@id="tree-node"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]/svg/path
    //*[@id="tree-node"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1] */

    @AfterAll
    public static void closeSEL(){
      driver.quit();

    }
}
