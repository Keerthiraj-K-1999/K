package HDFC.PRINFRA.VendorResubmit;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class VendorResubmit {

    Page page;
    Login login;
    Logout logout;
    Properties properties;

    private VendorResubmit(){
    }

    //TODO Constructor
    public  VendorResubmit(Page page,Login login,Logout logout,Properties properties){

        this.page = page;
        this.login = login;
        this.logout = logout;
        this.properties = properties;
    }

    public void VendorResubmit() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethodVendor();
        Thread.sleep(2000);
        page.locator("//span[text()='Digital Invoices']").click();
        Thread.sleep(1000);
        page.locator("//mat-icon[text()='edit']").first().click();
        Thread.sleep(2000);
        page.locator("//tbody/tr[2]/mat-cell[1]/mat-checkbox[1]/label[1]/div[1]").click();
        Thread.sleep(2000);
        page.locator("//body[1]/app-root[1]/div[1]/app-procurement[1]" +
                "/app-layout[1]/mat-drawer-container[1]/mat-drawer-content[1]/" +
                "div[1]/app-invoice-editor[1]/div[2]/form[1]/div[1]/div[1]/mat-" +
                "accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[4]" +
                "/div[1]/table[1]/tbody[1]/tr[2]/td[3]/button[1]/span[1]/mat-icon[1]").click();
        Thread.sleep(1000);
        Locator HSNnumber = page.locator("//input[@placeholder='Search with Hsn Value']");
        HSNnumber.fill(properties.getProperty("HSNNumber"));
        Thread.sleep(2000);
        page.keyboard().press("Enter");
        page.locator("//span[text()=' 999800 ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()='Update']").click();
        Thread.sleep(1000);
        Locator InvoiceQTY = page.locator("//*[@id=\"item-table\"]/tbody/tr[2]/td[6]/input");
        InvoiceQTY.fill("1");
        Thread.sleep(1000);
        page.locator("//*[@id=\"item-table\"]/tbody/tr[2]/td[4]/button[2]/span/mat-icon").click();
        Locator SerialNumber = page.locator("//span[text()='Serial Number']");
        SerialNumber.fill(properties.getProperty("SerialNumberItem2"));
        Thread.sleep(2000);
        page.locator("//span[text()=' Update ']").last().click();
        Thread.sleep(1000);
        page.locator("//span[text()=' Update ']").click();

        Thread.sleep(2000);
        logout.Logout();


    }
}
