package PlayWrightFactory;
import Base.BaseMain;
import Factory.Factory;
import HDFC.Login.Login;
import HDFC.PR.PR;
import com.microsoft.playwright.Page;
import java.io.IOException;
import java.util.Properties;

public class PlayWrightFactory  {

    static BaseMain baseMain;
    static Page page;
    static Properties properties;
    static Login login;
    static Factory factory;
    static PR pr;

    public static void main(String[] args) throws IOException {
        baseMain = new BaseMain();
        page = baseMain.initializeBrowser();
        properties = baseMain.propertiesInitializeInput();
        baseMain.testMethod(page);
        login = new Login(properties, page);
        pr = new PR(properties,page);
        factory= new Factory(login,pr);
        factory.Name();




    }
}

