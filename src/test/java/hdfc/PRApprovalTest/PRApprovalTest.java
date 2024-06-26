package hdfc.PRApprovalTest;

import hdfc.base.BaseTestClass;
import org.testng.annotations.Test;

public class PRApprovalTest extends BaseTestClass {

    public PRApprovalTest(){
    }

    @Test
    public void PRApprovalTestMethod() throws InterruptedException {
        prApproval.PRApproval();
        prApproval.PRApproval1();
    }
}
