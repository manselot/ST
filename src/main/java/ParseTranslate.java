import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ParseTranslate {
    public static String parse(String text) throws InterruptedException {
        String result = "";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abuzer\\Desktop\\chromedriver.exe");
        String url = "https://translate.google.com/?sl=auto&tl=ru&text="+ text +"&op=translate";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        wait.until(visibilityOfElementLocated(By.className("Q4iAWc")));
        for (WebElement element : driver.findElements(By.className("Q4iAWc"))) {
            result += element.getText();
        }
        driver.quit();
        return result;
    }
}

