import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest() {
        // open login/Reg form
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginBtn.click();
        // fill login/reg form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("leo.fil87@gmail.com");

        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Leonida$1987");


        // click login button
        wd.findElement(By.xpath("button[1]")).click();
        // assert if button logout is present
        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0);
    }

    @Test
    public void loginTest2 () {
        String email = "leo.fil87@gmail.com";
        String password = "Leonida$1987";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitLogin();
        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }
}
