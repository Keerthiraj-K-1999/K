package Base;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseMain {

    Playwright playwright;
    Browser browser;
    Page page;
    Properties properties;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    public BaseMain() throws FileNotFoundException {
        this.fileInputStream = new FileInputStream("C:\\Users\\Corm\\IdeaProjects\\HDFC\\src\\test\\resources\\Config\\properties");
        this.properties = new Properties();

    }

    public Page initializeBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        page = browser.newPage();
        return page;
    }

    public Properties propertiesInitializeInput() throws IOException {
        properties.load(fileInputStream);
        return properties;
    }

    public void testMethod(Page page){
        page.navigate(properties.getProperty("url"));

    }



}
