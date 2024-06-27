package HDFC.PRINFRA.POApproval;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class POApproval {

    Page page;
    Login login;
    Logout logout;
    Properties properties;

    public POApproval(){

    }

    //TODO Constructor
    public POApproval(Page page, Login login, Logout logout, Properties properties){

        this.page = page;
        this.login = login;
        this.logout = logout;
        this.properties = properties;
    }

    public void POApproval() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethod(properties.getProperty("FinalApproval"));

        Thread.sleep(1000);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Orders INFRA']").click();
        }
        else {
            Locator InfraButton = page.locator("//span[text()='INFRA']");
            if (InfraButton.isVisible()) {
                System.out.println("ui login");
                page.locator("//*[contains(text(), 'close')]").click();
                page.locator("//span[text()='Purchase Orders INFRA']").click();
            }
            else
            {
                page.locator("//span[text()='Purchase Orders INFRA']").click();
            }
        }


        Thread.sleep(50000);
        page.reload();
        Thread.sleep(2000);
        page.locator("//span[text()='Items']").click();
        Thread.sleep(2000);
        page.locator("//span[text()='Purchase Orders INFRA']").click();
        Thread.sleep(2000);
        page.locator("//mat-icon[text()='details']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Approve ']").click();
        page.locator("//*[contains(text(), ' Submit ')]").click();
        Thread.sleep(2000);
        logout.Logout();

    }
}
