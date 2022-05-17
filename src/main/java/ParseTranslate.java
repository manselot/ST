import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ParseTranslate {
    public static String parse(String text) throws TesseractException, IOException, InterruptedException {
        String result = "";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        String url = "https://translate.google.com/?sl=auto&tl=ru&text="+ text +"&op=translate";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        try {
            wait.until(visibilityOfElementLocated(By.className("Q4iAWc")));
        } catch (org.openqa.selenium.TimeoutException e) {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/C", "src/main/resources/kill_chromedriver.bat");
            Process process = processBuilder.start();
            process.destroy();
            driver.quit();
        }
        for (WebElement element : driver.findElements(By.className("Q4iAWc"))) {
            result += element.getText();
        }
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/C", "src/main/resources/kill_chromedriver.bat");
        Process process = processBuilder.start();
        process.destroy();
        driver.quit();
        return result;
    }
}

