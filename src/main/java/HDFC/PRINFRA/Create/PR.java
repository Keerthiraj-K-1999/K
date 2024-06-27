package HDFC.PRINFRA.Create;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PRINFRA.PRApprovalAdding.PRApprovalAdding;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class PR {

    Page page;
    Properties properties;
    Login login;
    Logout logout;
    PRApprovalAdding prApprovalAdding;

    private PR() {
    }

    //TODO Constructor
    public PR(Properties properties, Page page, Login login,Logout logout) {
        this.page = page;
        this.properties = properties;
        this.login = login;
        this.logout = logout;
        this.prApprovalAdding = new PRApprovalAdding(properties,page,logout);
    }

   public void PRCreate() throws InterruptedException {

       login.LoginMethod(properties.getProperty("EmailID"));

       Thread.sleep(1000);
       Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
       if (loginNote.isVisible()) {
           System.out.println("ui 2 login");
           Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
           Proceed.click();
           page.locator("//span[text()='Purchase Requisitions Infra']").click();
       }
//       else {
//           Locator InfraButton = page.locator("//span[text()='INFRA']");
//           if (InfraButton.isVisible()) {
//               System.out.println("ui login");
//               page.locator("//*[contains(text(), 'close')]").click();
//               page.locator("//span[text()='Purchase Requisitions Infra']").click();
//           }
       else {
           page.locator("//span[text()='Purchase Requisitions Infra']").click();
       }



       page.locator("//*[contains(text(), ' Create ')]").click();
       page.locator("//*[contains(text(), ' Non-FPN ')]").first().click();
       Locator Location = page.locator("#mat-input-4").first();
       Location.fill(properties.getProperty("LocationCode"));
       Locator count = page.locator("//span[text()='4989']");
       count.click();
       page.locator("//span[text()='Floor Number']").first().click();
       page.locator("//span[text()=' 1 - First Floor ']").click();
       page.locator("//span[text()='GST Type']").first().click();
       page.locator("//span[text()=' Normal Banking']").click();
       page.locator("//*[contains(text(), 'OK')]").click();
       Locator AdminOwner = page.locator("#mat-input-10").first();
       AdminOwner.fill(properties.getProperty("LocationAdminowner"));
       page.locator("//span[text()='B6255']").click();
       Locator AdminOwner1 = page.locator("#mat-input-11").first();
       AdminOwner1.fill(properties.getProperty("LocationAdminowner1"));
       page.locator("//span[text()='B6255']").click();
       page.locator("//span[text()=' Next ']").first().click();
       page.locator("#mat-select-16").click();
       page.locator("//span[text()=' Air Purifier ']").click();
   }


    public void itemAdd() {
        //Item 1
        page.locator("#mat-checkbox-3").click();
        int quantity = 5;
        Locator input = page.locator("#itquantityid0");
        input.fill(String.valueOf(quantity));
//TODO Event Trigger
        input.evaluate("el => { el.dispatchEvent(new Event('keyup', { bubbles: true })); }");
        Locator Addtocart =page.locator("//mat-tab-body/div[1]/section[1]/div[4]/div[1]/div[3]/div[1]/button[1]");
        Addtocart.click();

        //Item 2
        page.locator("#mat-checkbox-4").click();
        Locator input1 = page.locator("#itquantityid1");
        input1.fill("5");
//TODO Event Trigger
        input1.evaluate("el => { el.dispatchEvent(new Event('keyup', { bubbles: true })); }");
        Locator Addtocart1 =page.locator("//mat-tab-body/div[1]/section[1]/div[4]/div[1]/div[3]/div[1]/button[1]");
        Addtocart1.click();

    }

    public void ADDITIONALDETAILS() throws InterruptedException {

        Locator Next = page.locator("//body/app-root[1]/div[1]/app-procurement[1]/app-layout[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/app-purchase-requisition-non-fpn-create[1]/section[1]/div[2]/div[1]/mat-horizontal-stepper[1]/div[2]/div[2]/footer[1]/button[3]/span[1]");
        Next.click();
        Locator costcode = page.locator("#mat-input-12");
        costcode.fill("2117");
        page.locator("//span[text()='2117']").click();
        Locator costcodevalue = page.locator("#mat-input-37");
        costcodevalue.fill("100");
        page.locator("//span[text()=' Add Cost Code ']").click();
        Locator Next1 = page.locator("//body/app-root[1]/div[1]/app-procurement[1]/app-layout[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/app-purchase-requisition-non-fpn-create[1]/section[1]/div[2]/div[1]/mat-horizontal-stepper[1]/div[2]/div[3]/footer[1]/button[3]/span[1]");
        Next1.click();

        prApprovalAdding.PRApprovalAdding();
        logout.Logout();



    }

}




