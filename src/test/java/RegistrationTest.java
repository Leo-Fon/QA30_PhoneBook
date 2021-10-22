import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition () {
      /*  if(isLogged()) {
            logout();
        } */
    }

    @Test
    public void registrationTestPositive() {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        String email = "nik"+i+"@gmail.com";
        String password = "Leonida$";
        System.out.println("Email : "+ email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();

        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }

    public void type (By locator,String text) {
        if(text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    @Test
    public void registrationTestWrongEmail() {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        String email = "nik"+i+"@gmail.com";
        String password = "Leonida$";
        System.out.println("Email : "+ email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        Assert.assertFalse(isElementPresent(By.xpath("//button[text()='sign Out")));

    }
}
