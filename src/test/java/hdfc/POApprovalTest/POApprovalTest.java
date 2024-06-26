package hdfc.POApprovalTest;

import hdfc.base.BaseTestClass;
import org.testng.annotations.Test;

public class POApprovalTest extends BaseTestClass {

    public POApprovalTest(){
    }

    @Test
    public void POApprovalTestMethod() throws InterruptedException {

        poApproval.POApproval();

    }
}
