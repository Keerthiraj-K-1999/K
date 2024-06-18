package HDFC.PR.PRApprovalAdding;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Properties;

public class PRApprovalAdding {


    Page page;
    Properties properties;
    Logout logout;

    private PRApprovalAdding() {
    }


    //TODO Constructor
    public PRApprovalAdding(Properties properties, Page page, Logout logout) {
        this.page = page;
        this.properties = properties;
        this.logout = logout;
    }

    public void PRApprovalAdding() throws InterruptedException {

        page.locator("//span[text()='Add Approvers']").first().click();
        Locator Firstapproval = page.locator("#mat-input-39");
        Firstapproval.fill(properties.getProperty("FirstApprovalAddingPREmailID"));
        page.locator("//span[text()='procurementmanagerwest@sharklasers.com ']").click();
        page.locator("//span[text()='Add Approvers']").last().click();
        Locator Secondapproval = page.locator("#mat-input-40");
        Secondapproval.fill(properties.getProperty("SecondApprovalAddingPREmailID"));
        page.locator("//span[text()='businessheadcx@sharklasers.com ']").click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Apply Approvers ']").click();
        page.locator("//mat-icon[text()='done_all']").last().click();
        page.locator("//span[text()=' Yes ']").click();

    }
    public void EditApprovalAdding() throws InterruptedException {

        page.locator("//span[text()='Add Approvers']").first().click();
        Locator Firstapproval = page.locator("//input[@placeholder='Search by Employee Code, Employee Name, Email']");
        Firstapproval.fill(properties.getProperty("EditFirstApprovalAddingPREmailID"));
        page.locator("//span[text()='procurementmanagerwest@sharklasers.com ']").click();
        page.locator("//span[text()='Add Approvers']").last().click();
        Thread.sleep(2000);
        Locator Secondapproval = page.locator("//input[@placeholder='Search by Employee Code, Employee Name, Email']");
        Secondapproval.fill(properties.getProperty("EditSecondApprovalAddingPREmailID"));
        page.locator("//span[text()='businessheadcx@sharklasers.com ']").click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Apply Approvers ']").click();
        Thread.sleep(2000);
        page.locator("//mat-icon[text()='done_all']").last().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Yes ']").click();


    }

    public void BOQCreateAddingApprovalCycle() throws InterruptedException {


        page.locator("//span[text()='Add Approvers']").first().click();
        Locator Firstapproval = page.locator("//input[@placeholder='Search by Employee Code, Employee Name, Email']");
        Firstapproval.fill(properties.getProperty("BOQLevelFirst"));
        page.locator("//span[text()='procurementmanagerwest@sharklasers.com ']").click();
        page.locator("//span[text()='Add Approvers']").last().click();
        Thread.sleep(2000);
        Locator Secondapproval = page.locator("//input[@placeholder='Search by Employee Code, Employee Name, Email']");
        Secondapproval.fill(properties.getProperty("BOQLevelSecond"));
        page.locator("//span[text()='functionalhead@sharklasers.com ']").click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Apply Approvers ']").click();
        Thread.sleep(2000);
        page.locator("//mat-icon[text()='done_all']").last().click();
        Thread.sleep(2000);
        page.locator("//span[text()=' Yes ']").click();


    }

}
