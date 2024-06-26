package HDFC.PRINFRA.VendorInvoiceCreate;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Properties;

public class Vendor {

    Page page;
    Properties properties;
    Login login;
    Logout logout;

    private Vendor(){
    }

    //TODO Constructor
    public Vendor(Properties properties, Page page,Login login) {
        this.properties = properties;
        this.page = page;
        this.login = login;
        this.logout = new Logout(properties,page);
    }

    public void Vendor() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethodVendor();
        Thread.sleep(2000);
        page.locator("//span[text()='Digital Invoices']").click();
        Thread.sleep(2000);
        page.locator("//span[text()='Purchase Orders']").click();
        Thread.sleep(1000);
        page.locator("//td[text()='BLUE STAR LIMITED']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Acknowledge ']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()='Submit']").click();
        Thread.sleep(10000);
        page.locator("//td[text()='BLUE STAR LIMITED']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Submit Invoice ']").first().click();
        Locator InvoiceNumber =  page.locator("//mat-label[text()='Invoice Number *']");
        InvoiceNumber.fill(properties.getProperty("InvoiceNumber"));
        Thread.sleep(2000);
        Locator INRNumber = page.locator("//mat-label[text()='Invoice Reference Number (IRN)']");
        INRNumber.fill(properties.getProperty("INRNumber"));
        Thread.sleep(2000);
        page.locator("//span[text()='Invoice Type']").first().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Supply and installation  ']").click();
        page.locator("//button[@aria-label='Open calendar']").last().click();
        Thread.sleep(2000);
        page.locator("//td[@aria-label='20 June 2024']").click();
        Locator ContactNumber = page.locator("//span[text()='Contact Number']");
        ContactNumber.fill(properties.getProperty("ContactNumber"));
        Locator Details = page.locator("//span[text()='Supply Invoice Details']");
        Details.fill(properties.getProperty("Details"));
        Thread.sleep(2000);
        page.locator(".mat-checkbox.mat-accent").first().click();
        Thread.sleep(2000);
        page.locator("//tbody/tr[1]/mat-cell[1]/mat-checkbox[1]/label[1]/div[1]").click();
        Thread.sleep(2000);
        page.locator("//mat-icon[text()='edit']").first().click();
        Thread.sleep(2000);
        Locator HSNnumber = page.locator("//input[@placeholder='Search with Hsn Value']");
        HSNnumber.fill(properties.getProperty("HSNNumber"));
        Thread.sleep(2000);
        page.keyboard().press("Enter");
        page.locator("//span[text()=' 999800 ']").click();
        Thread.sleep(1000);
        page.locator("//span[text()='Update']").click();
        Thread.sleep(1000);
        Locator InvoiceQTY = page.locator("//input[@class='ng-untouched ng-pristine ng-valid']");
        InvoiceQTY.fill("1");
        Thread.sleep(1000);
        page.locator("//button[@mattooltip='add serial number']").first().click();
        Thread.sleep(1000);
        Locator SerialNumber = page.locator("//span[text()='Serial Number']");
        SerialNumber.fill(properties.getProperty("SerialNumber"));
        Thread.sleep(1000);
        page.locator("//span[text()=' Update ']").click();

        Thread.sleep(2000);
        FileChooser fileChooser = page.waitForFileChooser(() -> page.click("//*[contains(text(), 'attach_file')]"));
        fileChooser.setFiles(Paths.get("C://Users//Corm//IdeaProjects//Files//Invoice.csv"));

        FileChooser fileChooser2 = page.waitForFileChooser(() -> page.click("//body[1]/app-roo" +
                "t[1]/div[1]/app-procurement[1]/app-layout[1]/mat-drawer-container[1]/mat-" +
                "drawer-content[1]/div[1]/app-invoice-editor[1]/div[2]/div[3]/div[1]" +
                "/mat-accordion[1]/mat-expansion-panel[1]/div[1]" +
                "/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/button[1]/span[1]/mat-icon[1]"));
        fileChooser2.setFiles(Paths.get("C://Users//Corm//IdeaProjects//Files//Invoice.csv"));

        FileChooser fileChooser3 = page.waitForFileChooser(() -> page.click("//body[1]/app-root[1]/div[1]" +
                "/app-procurement[1]/app-layout[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]" +
                "/app-invoice-editor[1]/div[2]/div[3]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]" +
                "/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[4]/button[1]/span[1]"));
        fileChooser3.setFiles(Paths.get("C://Users//Corm//IdeaProjects//Files//Invoice.csv"));

        Thread.sleep(1000);
        page.locator("//span[text()=' Create ']").click();

        Thread.sleep(1000);
        logout.Logout();



//        Locator uploadFile = page.locator("//*[contains(text(), 'attach_file')]").first();
//        uploadFile.click();
//        uploadFile.setInputFiles(Paths.get("C://Users//Corm//IdeaProjects//Files//Invoice.csv"));


    }
}
