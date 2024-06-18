package HDFC.PR.PRApproval;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class PRApproval {

    Page page;
    Login login;
    Properties properties;
    Logout logout;


    private PRApproval() {
    }


    //TODO Constructor
    public PRApproval(Page page, Login login, Properties properties, Logout logout) {
        this.page = page;
        this.login = login;
        this.properties = properties;
        this.logout = logout;

    }

    public void PRApproval() throws InterruptedException {

        Thread.sleep(2000);
//PRApproverfirstlevel
        String EmailID1 = properties.getProperty("PRApproverfirstlevel");
        login.LoginMethod(EmailID1);
        Thread.sleep(2000);
        page.locator("//button[@mattooltip='view Details']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Approve ']").click();
        page.locator("#mat-input-7").fill("ok");
        page.locator("//*[contains(text(), ' Submit ')]").click();

        Thread.sleep(2000);
        logout.Logout();
    }

        public void PRApproval1() throws InterruptedException {

//PRApproverSecondlevel
        Thread.sleep(2000);
        login.LoginMethod1();
        Thread.sleep(2000);
        page.locator("//button[@mattooltip='view Details']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Approve ']").click();
        page.locator("#mat-input-7").fill("ok");
        page.locator("//*[contains(text(), ' Submit ')]").click();


        Thread.sleep(2000);
        logout.Logout();


    }


}
