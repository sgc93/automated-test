import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chat {
    void startChat() {
        System.setProperty("webdriver.chrome.driver", Constants.chrome_drive_path);
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aichatting.net/");
        
        WebElement searchBox = driver.findElement(By.className("Chatbox_inputArea__Z6XRW"));
        searchBox.sendKeys("what is selenium?");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("sendBtn")));
        searchBtn.click();

        WebElement answer = wait
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[@class='MessageItem_msg__C8oWx']/div)")));
        WebElement textcontent = answer.findElement(By.tagName("span"));
                System.out.println(textcontent.getText());

        try{
            Thread.sleep( 5000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        driver.close();
    }
}
