package HDFC.PRINFRA.CheckListAccept;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class CheckListAccept {

    Page page;
    Login login;
    Logout logout;
    Properties properties;

    private CheckListAccept(){
    }

    //TODO Constructor
    public CheckListAccept(Page page,Login login,Logout logout,Properties properties){

        this.page = page;
        this.login = login;
        this.logout = logout;
        this.properties = properties;

    }

    public void CheckListAccept() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethodInvoiceChecker();
        Thread.sleep(1000);
        page.locator("//mat-icon[text()='details']").first().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' CheckList ']").first().click();
        Thread.sleep(2000);
        page.locator("//div[contains(@class, 'mat-checkbox-inner-container-no-side-margin')]").first().click();
        Thread.sleep(1000);
        page.locator("//*[@id=\"cdk-accordion-child-12\"]" +
                "/div/div/div/table/tbody/tr[2]/td[6]/div/button[1]/span").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Accept ']");
   //     page.locator("NA");



    }



}
