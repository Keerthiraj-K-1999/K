package HDFC.PRINFRA.CheckListReview;

import HDFC.Login.Login;
import HDFC.Logout.Logout;
import com.microsoft.playwright.Page;

public class CheckListReview {

    Page page;
    Login login;
    Logout logout;

    private CheckListReview(){
    }

    //TODO Constructor
    public CheckListReview(Page page,Login login,Logout logout){

        this.page = page;
        this.login = login;
        this.logout = logout;
    }

    public void CheckListReview() throws InterruptedException {

        Thread.sleep(2000);
        login.LoginMethodInvoiceChecker();
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
