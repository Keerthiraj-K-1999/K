package Factory;
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

public class Factory {

    Login login;
    PR pr;
    PRApprovalAdding prApprovalAdding;
    Logout logout;
    Reject reject;
    Edit edit;
    PRApproval approval;
    BOQCreate boqCreate;
    PRApprovalAdding boqCreateAddingApprovalCycle;
    BOQApproval boqApproval;
    POApproval poApproval;
    Vendor vendor;
    CheckListReview checkListReview;
    VendorResubmit vendorResubmit;
    CheckListAccept checkListAccept;


    private Factory(){
    }

    public Factory(Login login, PR pr, PRApprovalAdding prApprovalAdding,
                   Logout logout, Reject reject, Edit edit, PRApproval approval ,
                   BOQCreate boqCreate, PRApprovalAdding boqCreateAddingApprovalCycle ,
                   BOQApproval boqApproval,POApproval poApproval,Vendor vendor,
                   CheckListReview checkListReview,VendorResubmit vendorResubmit,CheckListAccept checkListAccept){


        this.login = login;
        this.pr = pr;
        this.prApprovalAdding = prApprovalAdding;
        this.logout = logout;
        this.reject = reject;
        this.edit = edit;
        this.approval = approval;
        this.boqCreate = boqCreate;
        this.boqCreateAddingApprovalCycle = boqCreateAddingApprovalCycle;
        this.boqApproval = boqApproval;
        this.poApproval = poApproval;
        this.vendor = vendor;
        this.checkListReview = checkListReview;
        this.vendorResubmit = vendorResubmit;
        this.checkListAccept = checkListAccept;

    }

    public void Name() throws InterruptedException {

//        pr.PRCreate();
//        pr.itemAdd();
//        pr.ADDITIONALDETAILS();
//        reject.Reject();
//        edit.Edit();
//        edit.EditPageAddingItem();
//        approval.PRApproval();
//        approval.PRApproval1();
//        boqCreate.BOQCreate();
//        boqApproval.BOQApproval();
//        boqApproval.BOQApproval2();
//        poApproval.POApproval();
//        vendor.Vendor();
//        checkListReview.CheckListReview();
//        vendorResubmit.VendorResubmit();
        checkListAccept.CheckListAccept();

    }



}
