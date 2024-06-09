package org.example;
import com.microsoft.playwright.*;

public class HDFC {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://cpc_uat_admin.cormsquare.com/myLogin");
            System.out.println(page.title());


        }


    }
}