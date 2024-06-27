package HDFC.PRINFRA.InvoiceApproval;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class InvoiceApproval {

    Page page;
    Login login;
    Logout logout;
    Properties properties;

    private InvoiceApproval(){
    }

    //TODO Constructor
    public InvoiceApproval(Page page,Login login,Logout logout,Properties properties){

        this.page = page;
        this.login = login;
        this.logout = logout;
        this.properties = properties;

    }

    public void InvoiceApprovalMethod() throws InterruptedException {

        Thread.sleep(2000);

        String[] Approver = {(properties.getProperty("InvoiceApprovalEmailID1")),(properties.getProperty("InvoiceApprovalEmailID2"))};
        for(int i=0;i< Approver.length;i++) {
            Thread.sleep(2000);
            login.LoginMethod(Approver[i]);

            Thread.sleep(1000);
            Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
            if (loginNote.isVisible()) {
                System.out.println("ui 2 login");
                Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
                Proceed.click();
                page.locator("//span[text()='Digital Invoices']").click();
            }
            else {
                Locator InfraButton = page.locator("//span[text()='INFRA']");
                if (InfraButton.isVisible()) {
                    System.out.println("ui login");
                    page.locator("//*[contains(text(), 'close')]").click();
                    page.locator("//span[text()='Digital Invoices']").click();
                }
                else
                {
                    page.locator("//span[text()='Digital Invoices']").click();
                }
            }

            Thread.sleep(2000);
            page.locator("//mat-icon[text()='details']").first().click();
            Thread.sleep(2000);
            page.locator("//span[text()=' Approve ']").last().click();
            Thread.sleep(1000);
            page.locator("//*[contains(text(), ' Submit ')]").last().click();

            Thread.sleep(2000);
            logout.Logout();
        }







    }
}
