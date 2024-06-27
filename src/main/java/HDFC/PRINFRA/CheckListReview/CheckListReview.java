package HDFC.PRINFRA.CheckListReview;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class CheckListReview {

    Page page;
    Login login;
    Logout logout;
    Properties properties;

    private CheckListReview(){
    }

    //TODO Constructor
    public CheckListReview(Page page,Login login,Logout logout,Properties properties){

        this.page = page;
        this.login = login;
        this.logout = logout;
        this.properties = properties;
    }

    public void CheckListReview() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethod(properties.getProperty("InvoiceChecker"));

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

        Thread.sleep(1000);
        page.locator("//mat-icon[text()='details']").first().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' CheckList ']").first().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Add to Review Queue ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Submit For Review ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Submit ']").last().click();

        Thread.sleep(1000);
        logout.Logout();

    }


}
