package HDFC.PRINFRA.PRApproval;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
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

        String[] Approver = {(properties.getProperty("PRApproverfirstlevel")), (properties.getProperty("PRApproversecondlevel"))};
        for (int i = 0; i < Approver.length; i++) {
            Thread.sleep(2000);
            login.LoginMethod(Approver[i]);
            Thread.sleep(1000);
            Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
            if (loginNote.isVisible()) {
                System.out.println("ui 2 login");
                Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
                Proceed.click();
                page.locator("//span[text()='Purchase Requisitions Infra']").click();
            }
            else {
                Locator InfraButton = page.locator("//span[text()='INFRA']");
                if (InfraButton.isVisible()) {
                    System.out.println("ui login");
                    page.locator("//*[contains(text(), 'close')]").click();
                    page.locator("//span[text()='Purchase Requisitions Infra']").click();
                }
                else
                {
                    page.locator("//span[text()='Purchase Requisitions Infra']").click();
                }
            }

            page.locator("//button[@mattooltip='view Details']").first().click();
            Thread.sleep(2000);
            page.locator("//span[text()=' Approve ']").click();
            page.locator("#mat-input-7").fill("ok");
            page.locator("//*[contains(text(), ' Submit ')]").click();

            Thread.sleep(2000);
            logout.Logout();
        }

    }
}


