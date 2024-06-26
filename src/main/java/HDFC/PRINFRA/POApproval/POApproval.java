package HDFC.PRINFRA.POApproval;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
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
        login.LoginMethod3();
        Thread.sleep(40000);
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
