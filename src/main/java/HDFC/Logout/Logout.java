package HDFC.Logout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Properties;

public class Logout {

    Page page;
    Properties properties;

    private Logout() {
    }

    //TODO Constructor
    public Logout(Properties properties, Page page) {
        this.properties = properties;
        this.page = page;
    }

    public void Logout() throws InterruptedException {

        Thread.sleep(2000);
        page.locator("//mat-icon[text()='person']").click();
        page.locator("//span[text()='Log Out']").click();



    }
}
