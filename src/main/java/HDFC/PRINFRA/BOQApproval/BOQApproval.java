package HDFC.PRINFRA.BOQApproval;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class BOQApproval {
    Page page;
    Login login;
    Logout logout;
    Properties properties;

    public BOQApproval(){

    }
    //TODO Constructor
    public BOQApproval(Login login, Logout logout, Properties properties, Page page) {
        this.login = login;
        this.logout = logout;
        this.properties = properties;
        this.page = page;
    }


    public void BOQApproval() throws InterruptedException {

        Thread.sleep(2000);
//BOQApproverfirstlevel
        String EmailID1 = properties.getProperty("BOQLevelFirst");
        login.LoginMethod(EmailID1);
        Thread.sleep(2000);
        page.locator("//button[@mattooltip='view Details']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Approve ']").last().click();
        page.locator("#mat-input-7").fill("ok");
        page.locator("//*[contains(text(), ' Submit ')]").click();

        Thread.sleep(2000);
        logout.Logout();

    }

    public void BOQApproval2() throws InterruptedException {

        Thread.sleep(2000);
//BOQApproverfirstlevel
        login.LoginMethod2();
        Thread.sleep(2000);
        page.locator("//button[@mattooltip='view Details']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Approve ']").last().click();
        page.locator("#mat-input-7").fill("ok");
        page.locator("//*[contains(text(), ' Submit ')]").click();

        Thread.sleep(2000);
        logout.Logout();


    }




}
