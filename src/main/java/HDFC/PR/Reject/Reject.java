package HDFC.PR.Reject;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class Reject {

    Login login;
    Page page;
    Properties properties;
    Logout logout;

    private Reject(){

    }

    //TODO Constructor
    public Reject(Properties properties, Page page, Login login, Logout logout) {

        this.login = login;
        this.properties = properties;
        this.page = page;
        this.logout = logout;

    }

    public void Reject() throws InterruptedException{


        Thread.sleep(2000);
        String EmailID1 = properties.getProperty("PRApproverfirstlevel");
        login.LoginMethod(EmailID1);
        Thread.sleep(2000);
//        page.locator("#mat-input-2").click();
//        page.locator("//*[contains(text(), ' Search By Reference ID ')]").click();
//        Thread.sleep(2000);
//        Locator search = page.locator("//input[@placeholder='Search By Reference ID']");
//        search.click();
//        String referenceId = properties.getProperty("ReferenceId");
//        search.fill(referenceId);
//        search.evaluate("el => { el.dispatchEvent(new Event('keyup', { bubbles: true })); }");
//        Thread.sleep(2000);
//        page.locator("//span[text()=' Apply Filter ']").click();
//        Thread.sleep(2000);
//        page.keyboard().press("Enter");
//        Thread.sleep(4000);
        page.locator("//button[@mattooltip='view Details']").first().click();
        Thread.sleep(2000);
        page.locator("//*[contains(text(), ' Reject ')]").click();
        page.locator("#mat-input-7").fill("ok");
        page.locator("//*[contains(text(), ' Submit ')]").click();




    }


}
