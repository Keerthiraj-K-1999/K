package HDFC.PRINFRA.CheckListAccept;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
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
        Thread.sleep(2000);
        page.locator("//div[contains(@class, 'mat-checkbox-inner-container-no-side-margin')]").first().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Accept ']").click();
        Thread.sleep(1000);
        page.locator("//*[@id=\"cdk-accordion-child-4\"]" +
                "/div/div/div/table/tbody/tr[2]/td[6]/div/button[1]/span").click();
        Thread.sleep(1000);
        page.locator("//div[contains(@class, 'mat-checkbox-inner-container-no-side-margin')]").first().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Accept ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' CheckList ']").last().click();
        Thread.sleep(2000);
        page.locator("//div[contains(@class, 'mat-checkbox-inner-container-no-side-margin')]").first().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Accept ']").click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Accept Check List ']").click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Submit ']").last().click();
        Thread.sleep(2000);
        page.locator("//mat-icon[text()='edit']").first().click();
        Thread.sleep(2000);
        Locator SreachAddress = page.locator("//mat-label[text()='Vendor Location Search']");
        SreachAddress.fill(properties.getProperty("VendorAddress"));
        Thread.sleep(2000);
        page.keyboard().press("Enter");
        Thread.sleep(2000);
        page.locator(".mat-radio-container").last().click();
        Thread.sleep(2000);
        page.locator("//span[text()='Save']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Update Additional Details ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Update ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()='Select Approvers']").last().click();
        Thread.sleep(1000);
        Locator EamilID = page.locator("#mat-input-7");
        EamilID.fill(properties.getProperty("InvoiceApprovalEmailID"));
        Thread.sleep(1000);
        page.locator("//span[text()='peter@sharklasers.com ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Apply Approvers ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Send For Approval ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Yes ']").click();

        Thread.sleep(2000);
        logout.Logout();


    }



}