package PlayWrightFactory;
import Base.BaseMain;
import Factory.Factory;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PR.BOQApproval.BOQApproval;
import HDFC.PR.PRApproval.PRApproval;
import HDFC.PR.BOQCreate.BOQCreate;
import HDFC.PR.Edit.Edit;
import HDFC.PR.Reject.Reject;
import HDFC.PR.Create.PR;
import HDFC.PR.PRApprovalAdding.PRApprovalAdding;
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
    static PRApprovalAdding prApprovalAdding;
    static Logout logout;
    static Reject reject;
    static Edit edit;
    static PRApproval prApproval;
    static BOQCreate boqCreate;
    static PRApprovalAdding boqCreateAddingApprovalCycle;
    static BOQApproval boqApproval;





    public static void main(String[] args) throws IOException, InterruptedException {
        baseMain = new BaseMain();
        page = baseMain.initializeBrowser();
        properties = baseMain.propertiesInitializeInput();
        login = new Login(properties, page);
        pr = new PR(properties, page, login, logout);
        prApprovalAdding = new PRApprovalAdding(properties, page, logout);
        logout = new Logout(properties,page);
        reject = new Reject(properties,page,login,logout);
        edit = new Edit (properties,page,login,logout);
        prApproval = new PRApproval(page,login,properties,logout);
        boqCreate = new BOQCreate(login,logout,page,properties);
        boqApproval = new BOQApproval(login,logout,properties,page);
        factory= new Factory(login,pr,prApprovalAdding,logout,reject,edit,prApproval,boqCreate,boqCreateAddingApprovalCycle,boqApproval);
        factory.Name();


    }
}

