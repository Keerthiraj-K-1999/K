package hdfc.base;
import Base.BaseMain;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PRINFRA.BOQApproval.BOQApproval;
import HDFC.PRINFRA.BOQCreate.BOQCreate;
import HDFC.PRINFRA.CheckListReview.CheckListReview;
import HDFC.PRINFRA.Create.PR;
import HDFC.PRINFRA.Edit.Edit;
import HDFC.PRINFRA.POApproval.POApproval;
import HDFC.PRINFRA.PRApproval.PRApproval;
import HDFC.PRINFRA.Reject.Reject;
import HDFC.PRINFRA.VendorInvoiceCreate.Vendor;
import HDFC.PRINFRA.VendorResubmit.VendorResubmit;
import PlayWrightFactory.PlayWrightFactory;
import com.microsoft.playwright.Page;
import hdfc.BOQApprovalTest.BOQApprovalTest;
import hdfc.BOQCreateTest.BOQCreateTest;
import hdfc.CheckListReviewTest.CheckListReviewTest;
import hdfc.CreateTest.CreateTest;
import hdfc.EditTest.EditTest;
import hdfc.Logout.LogoutTest;
import hdfc.POApprovalTest.POApprovalTest;
import hdfc.PRApprovalTest.PRApprovalTest;
import hdfc.RejectTest.RejectTest;
import hdfc.VendorInvoiceCreateTest.InvoiceCreateTest;
import hdfc.VendorResubmitTest.VendorResubmitTest;
import hdfc.logintest.LoginTestClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.Properties;

public class BaseTestClass {

    public BaseMain baseMain;
    public PlayWrightFactory playWrightFactory;
    public LoginTestClass loginTestClass;
    public Login login;
    public Properties properties;
    public Page page;
    public PR pr;
    public CreateTest createTest;
    public Logout logout;
    public RejectTest rejectTest;
    public Reject reject;
    public EditTest editTest;
    public Edit edit;
    public PRApprovalTest prApprovalTest;
    public PRApproval prApproval;
    public BOQCreateTest boqCreateTest;
    public BOQCreate boqCreate;
    public BOQApprovalTest boqApprovalTest;
    public BOQApproval boqApproval;
    public POApprovalTest poApprovalTest;
    public POApproval poApproval;
    public LogoutTest logoutTest;
    public InvoiceCreateTest invoiceCreateTest;
    public Vendor vendor;
    public CheckListReviewTest checkListReviewTest;
    public CheckListReview checkListReview;
    public VendorResubmitTest vendorResubmitTest;
    public VendorResubmit vendorResubmit;



    @BeforeClass
    public void setup() throws IOException {
        baseMain = new BaseMain();
        properties = baseMain.propertiesInitializeInput();
        page = baseMain.initializeBrowser();


        login = new Login(properties, page);
        loginTestClass = new LoginTestClass();
        logout = new Logout(properties,page);
        pr = new PR(properties,page,login,logout);
        createTest = new CreateTest();
        reject = new Reject(properties,page,login,logout);
        rejectTest = new RejectTest();
        edit = new Edit(properties,page,login,logout);
        editTest = new EditTest();
        prApproval = new PRApproval(page,login,properties,logout);
        prApprovalTest = new PRApprovalTest();
        boqCreate = new BOQCreate(login,logout,page,properties);
        boqCreateTest = new BOQCreateTest();
        boqApproval = new BOQApproval(login,logout,properties,page);
        boqApprovalTest = new BOQApprovalTest();
        poApproval = new POApproval(page,login,logout,properties);
        poApprovalTest = new POApprovalTest();
        logoutTest = new LogoutTest();
        vendor = new Vendor(properties,page,login);
        invoiceCreateTest = new InvoiceCreateTest();
        checkListReview = new CheckListReview(page,login,logout);
        checkListReviewTest = new CheckListReviewTest();
        vendorResubmit = new VendorResubmit(page,login,logout,properties);
        vendorResubmitTest = new VendorResubmitTest();

    }

    @AfterClass
    public void teardown(){
        page.context().close();
    }
}