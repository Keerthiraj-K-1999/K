package HDFC.Login;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;


public class Login {

    Page page;
    Properties properties;
    //String Title = "P2P App";

    private Login() {
    }

    //TODO Constructor
    public Login(Properties properties, Page page) {
        this.properties = properties;
        this.page = page;
    }

    public void LoginMethod() throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("EmailID"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        } else {
            System.out.println("ui login");
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        }
    }

    public void LoginMethod(String getapprovalemailID) throws InterruptedException {

        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(getapprovalemailID);
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Locator Afterloginnote = page.locator("//*[contains(text(), 'INFRA')]");
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        } else if (Afterloginnote.isVisible()){
            System.out.println("ui login");
            page.locator("//*[contains(text(), 'close')]").click();
            System.out.println("ui 3 login");
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        }
    }
    public void LoginMethod1() throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("PRApproversecondlevel"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        } else {
            System.out.println("ui login");
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        }
    }

    public void LoginMethod2() throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("BOQLevelSecond"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        } else {
            System.out.println("ui login");
            page.locator("//span[text()='Purchase Requisitions Infra']").click();
        }
    }
    public void LoginMethod3() throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("FinalApproval"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Orders INFRA']").click();
        } else {
            System.out.println("ui login");
            page.locator("//span[text()='Purchase Orders INFRA']").click();
        }
    }

    public void LoginMethodVendor() throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("VendorEmailID"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Purchase Orders']").click();
        } else {
            System.out.println("ui login");
            page.locator("//span[text()='Purchase Orders']").click();
        }
    }

    public void LoginMethodInvoiceChecker() throws InterruptedException {
        String loginUrl = properties.getProperty("url");
        page.navigate(loginUrl);
        Locator loginNote = page.locator("//*[contains(text(), 'Unauthorized use of the HDFC Bank applications is prohibited')]");
        Locator mailId = page.locator("//input[@id='mat-input-0']");
        mailId.fill(properties.getProperty("InvoiceChecker"));
        Locator password = page.locator("//input[@id='mat-input-1']");
        password.fill(properties.getProperty("Password"));
        Locator loginButton = page.locator("//button[contains(text(), ' Login ')]");
        loginButton.click();
        Thread.sleep(2000);

        if (loginNote.isVisible()) {
            System.out.println("ui 2 login");
            Locator Proceed = page.locator("//*[contains(text(), ' Proceed ')]");
            Proceed.click();
            page.locator("//span[text()='Digital Invoices']").click();
        } else {
            System.out.println("ui login");
            page.locator("//span[text()='Digital Invoices']").click();
        }
    }
}
