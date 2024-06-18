package Factory;
import HDFC.Login.Login;
import HDFC.Logout.Logout;
import HDFC.PR.BOQApproval.BOQApproval;
import HDFC.PR.PRApproval.PRApproval;
import HDFC.PR.BOQCreate.BOQCreate;
import HDFC.PR.Edit.Edit;
import HDFC.PR.Reject.Reject;
import HDFC.PR.Create.PR;
import HDFC.PR.PRApprovalAdding.PRApprovalAdding;

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


    private Factory(){
    }

    public Factory(Login login, PR pr, PRApprovalAdding prApprovalAdding, Logout logout, Reject reject, Edit edit, PRApproval approval , BOQCreate boqCreate, PRApprovalAdding boqCreateAddingApprovalCycle , BOQApproval boqApproval){
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

    }

    public void Name() throws InterruptedException {

        pr.PRCreate();
        pr.itemAdd();
        pr.ADDITIONALDETAILS();
        prApprovalAdding.PRApprovalAdding();
        logout.Logout();
        reject.Reject();
        edit.Edit();
        edit.EditPageAddingItem(prApprovalAdding);
        approval.PRApproval();
        approval.PRApproval1();
        boqCreate.BOQCreate(prApprovalAdding);
        boqApproval.BOQApproval();
        boqApproval.BOQApproval2();


    }



}
