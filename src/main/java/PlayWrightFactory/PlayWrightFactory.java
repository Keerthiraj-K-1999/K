package PlayWrightFactory;
import Base.BaseMain;
import Factory.Factory;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PRINFRA.BOQApproval.BOQApproval;
import HDFC.PRINFRA.CheckListAccept.CheckListAccept;
import HDFC.PRINFRA.CheckListReview.CheckListReview;
import HDFC.PRINFRA.POApproval.POApproval;
import HDFC.PRINFRA.PRApproval.PRApproval;
import HDFC.PRINFRA.BOQCreate.BOQCreate;
import HDFC.PRINFRA.Edit.Edit;
import HDFC.PRINFRA.Reject.Reject;
import HDFC.PRINFRA.Create.PR;
import HDFC.PRINFRA.PRApprovalAdding.PRApprovalAdding;
import HDFC.PRINFRA.VendorInvoiceCreate.Vendor;
import HDFC.PRINFRA.VendorResubmit.VendorResubmit;
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
    static POApproval poApproval;
    static Vendor vendor;
    static CheckListReview checkListReview;
    static VendorResubmit vendorResubmit;
    static CheckListAccept checkListAccept;





    public static void main(String[] args) throws IOException, InterruptedException {
        baseMain = new BaseMain();
        page = baseMain.initializeBrowser();
        properties = baseMain.propertiesInitializeInput();
        login = new Login(properties, page);
        logout = new Logout(properties,page);
        pr = new PR(properties, page, login, logout);
        prApprovalAdding = new PRApprovalAdding(properties, page, logout);
        reject = new Reject(properties,page,login,logout);
        edit = new Edit (properties,page,login,logout);
        prApproval = new PRApproval(page,login,properties,logout);
        boqCreate = new BOQCreate(login,logout,page,properties);
        boqApproval = new BOQApproval(login,logout,properties,page);
        poApproval = new POApproval(page,login,logout,properties);
        vendor = new Vendor(properties,page,login);
        checkListReview = new CheckListReview(page,login,logout);
        vendorResubmit = new VendorResubmit(page,login,logout,properties);
        checkListAccept = new CheckListAccept(page,login,logout,properties);
        factory= new Factory(login,pr,prApprovalAdding,logout,reject,edit,prApproval,boqCreate,
                             boqCreateAddingApprovalCycle,boqApproval,poApproval,vendor,
                             checkListReview,vendorResubmit,checkListAccept);
        factory.Name();


    }
}

