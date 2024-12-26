package picture_upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class picture_test {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options); // Initialize WebDriver with options
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        try {
        	driver.get("https://hachnat.stage-carelogix.de/sing-in");

            // Wait for Username, Password, and Login button to be visible and enter credentials
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            username.sendKeys("Manjur");
            password.sendKeys("Carelogix24!!");
            loginButton.click();
            
            WebElement profilePicture = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div/header/div/div[3]/div[2]/a/div/div[1]/img")));
            profilePicture.click();

          
            WebElement userSettingsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div")));
            userSettingsOption.click();
            
            
            // Step 3: Click on '+' Icon
            WebElement plusIcon = driver.findElement(By.xpath("//*[@id=\"avatar\"]/div[1]/span/div/div[1]/div/span/button/span/button/span/svg"));
            plusIcon.click();
            Thread.sleep(20000000); // Wait for upload button to appear
            
            // Step 4: Click on the Upload Button
            WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"avatar\"]/div[1]/span/div/div/span/button/div"));
            uploadButton.click();
            Thread.sleep(20000000);
            
            // Step 5: Provide the File Path
            WebElement uploadInput = driver.findElement(By.xpath("//*[@id=\"avatar\"]/div[1]/span/div/div/span/input"));
            uploadInput.sendKeys("C:\\Users\\USER\\OneDrive\\Pictures\\Saved Pictures\\carelogix.jpg");
            Thread.sleep(20000000);
            
            // Step 6: Interact with the Edit Image Pop-Up 
            WebElement okButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/button[2]/span"));
            okButton.click();
            Thread.sleep(20000000); 
            
            // Step 7: Verify Profile Picture
            WebElement Picture = driver.findElement(By.xpath("//*[@id=\"avatar\"]/div[1]/span/div/div[1]/div"));
            if (profilePicture.isDisplayed()) {
                System.out.println("Profile picture uploaded successfully!");
            } else {
                System.out.println("Profile picture upload failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close the Browser
            driver.quit();
        }
    }
}


