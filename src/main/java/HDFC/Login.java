package HDFC;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.util.Properties;


public class Login {

    Page page;
    Properties properties;

    private Login() {
    }

    //TODO Constructor
    public Login(Properties properties, Page page) {
        this.properties = properties;
        this.page = page;
    }

    public void LoginMethod() {
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("EmailID"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        Locator Proceed = page.locator("//button[@class='mat-focus-indicator mr-2 mat-raised-button mat-button-base mat-primary']");
        Proceed.click();


    }

}
