import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    String query;
    String url;
    String webName;

    Test(String webName, String query) {
        if (webName == "youtube") {
            this.url = "https://www.youtube.com/";
            this.webName = webName;
        } else if (webName == "google") {
            this.url = "https://www.google.com";
            this.webName = webName;
        } else if (webName == "garix") {
            this.url = "https://garix.netlify.app/";
            this.webName = webName;
        } else if (webName == "ingit") {
            this.url = "https://ingit.netlify.app/";
            this.webName = webName;
        }
        this.query = query;
    }
    
    void test() {
        System.setProperty("webdriver.chrome.driver", Constants.chrome_drive_path);
        
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        if (webName == "youtube") {
            WebElement searchForm = wait.until(ExpectedConditions.elementToBeClickable(By.name("search_query")));
            searchForm.sendKeys(query);
            searchForm.submit();
        } else if (webName == "google") {
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(query);
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable((By.name("btnK"))));
            searchBtn.click();
        } else if (webName == "garix") {
            WebElement searchBox = driver.findElement(By.className("search__box"));
            searchBox.sendKeys(query);
        } else if(webName == "ingit"){
            WebElement searchBox = driver.findElement(By.tagName("input"));
            searchBox.sendKeys(query);
        }
        
        
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        if (webName == "ingit") {
            WebElement btn = wait
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.xpath("//div[@class='app__card-user']/button")));
            btn.click();
            try{
                Thread.sleep(1000*30);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        

        driver.close();
    }
}
