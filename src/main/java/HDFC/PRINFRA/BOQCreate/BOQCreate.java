package HDFC.PRINFRA.BOQCreate;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PRINFRA.PRApprovalAdding.PRApprovalAdding;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class BOQCreate {

    Page page;
    Login login;
    Logout logout;
    Properties properties;
    PRApprovalAdding prApprovalAdding;


    private BOQCreate(){

    }

    //TODO Constructor
    public BOQCreate(Login login , Logout logout, Page page , Properties properties) {

        this.page = page;
        this.login = login;
        this.logout = logout;
        this.properties = properties;
        this.prApprovalAdding = new PRApprovalAdding(properties,page,logout);
    }

    public void BOQCreate() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethod(properties.getProperty("EmailID"));

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
        page.locator("//span[text()=' Create BOQ ']").click();
        Thread.sleep(2000);
        page.locator("#mat-radio-5").first().click();
        Thread.sleep(2000);
        Locator SearchAddress = page.locator("//mat-label[text()='Vendor Location Search']");
        //SearchAddress.last().click();
        SearchAddress.fill(properties.getProperty("BOQCreatedVendorAddress"));
        Thread.sleep(2000);
        page.keyboard().press("Enter");
        Thread.sleep(2000);
        page.locator(".mat-radio-container").last().click();
        Thread.sleep(2000);
        page.locator("//span[text()='Save']").click();
        Thread.sleep(2000);
        page.locator("//span[text()='Add BOQ ']").click();

// BOQCreateAddingApprovalCycle

        prApprovalAdding.BOQCreateAddingApprovalCycle();
        Thread.sleep(2000);
        logout.Logout();


    }


}
