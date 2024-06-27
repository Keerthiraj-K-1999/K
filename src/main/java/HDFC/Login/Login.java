package HDFC.Login;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;


public class Login {

    Page page;
    Properties properties;
    //String Title = "P2P App";

    private Login() {
    }

    //TODO Constructor
    public Login(Properties properties, Page page) {
        this.properties = properties;
        this.page = page;
    }

    public void LoginMethod(String EmailID) throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(EmailID);
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

    }
}



