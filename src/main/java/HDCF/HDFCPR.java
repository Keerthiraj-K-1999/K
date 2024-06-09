package HDCF;
import com.microsoft.playwright.*;

public class HDFCPR {

    public static void main(String[] args) {

            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                Page page = browser.newPage();
                page.navigate("https://cpc_uat_admin.cormsquare.com/myLogin");
                System.out.println(page.title());


                String emailId = "Kaushik@Hdfcbank.com";
                String password = "Admin@123";
                page.locator("#mat-input-0").first().fill(emailId);
                page.locator("#mat-input-1").first().fill(password);
                page.locator("//button[contains(text(), 'Login')]").last().click();
                System.out.println("ABC");


        }
    }
}


