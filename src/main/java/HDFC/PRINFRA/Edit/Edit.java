package HDFC.PRINFRA.Edit;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PRINFRA.PRApprovalAdding.PRApprovalAdding;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class Edit {

    Login login;
    Page page;
    Properties properties;
    Logout logout;
    PRApprovalAdding prApprovalAdding;


    private Edit(){

    }

    //TODO Constructor
    public Edit(Properties properties, Page page, Login login ,Logout logout) {

        this.login = login;
        this.properties = properties;
        this.page = page;
        this.logout = logout;
        this.prApprovalAdding = new PRApprovalAdding(properties,page,logout);

    }

    public void Edit() throws InterruptedException {

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

        page.locator("//mat-icon[text()='edit']").first().click();
        page.locator("//span[text()=' Next ']").first().click();
        Thread.sleep(2000);
        page.locator("#mat-select-17").click();
        Thread.sleep(3000);
        page.locator("//span[text()=' Air Purifier ']").click();

    }

        public void EditPageAddingItem() throws InterruptedException {


            //Item 3
            page.locator("#mat-checkbox-7").click();
            Locator input = page.locator("#itquantityid2");
            input.fill("5");
//TODO Event Trigger
            input.evaluate("el => { el.dispatchEvent(new Event('keyup', { bubbles: true })); }");
            Locator Addtocart1 =page.locator("//span[text()='Add To Cart ']");
            Addtocart1.click();
            page.locator("//span[text()='OK']").click();

            //Item 4
            page.locator("#mat-checkbox-8").click();
            Locator input1 = page.locator("#itquantityid3");
            input1.fill("5");
//TODO Event Trigger
            input1.evaluate("el => { el.dispatchEvent(new Event('keyup', { bubbles: true })); }");
            Locator Addtocart =page.locator("//span[text()='Add To Cart ']");
            Addtocart.click();
            page.locator("//span[text()='OK']").click();


            //Item 5
            page.locator("#mat-checkbox-9").click();
            Locator input2 = page.locator("#itquantityid4");
            input2.fill("5");
//TODO Event Trigger
            input2.evaluate("el => { el.dispatchEvent(new Event('keyup', { bubbles: true })); }");
            Locator Addtocart2 =page.locator("//span[text()='Add To Cart ']");
            Addtocart2.click();
            page.locator("//span[text()='OK']").click();

            Locator Next = page.locator(".mat-focus-indicator.nextbtn").first();
            Next.click();

            Locator Next1 = page.locator(".mat-focus-indicator.nextbtn").last();
            Next1.click();

// UPDATING THE PR

            prApprovalAdding.EditApprovalAdding();
            Thread.sleep(2000);
            logout.Logout();


    }


}
