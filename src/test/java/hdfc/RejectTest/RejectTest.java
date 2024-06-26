package hdfc.RejectTest;

import hdfc.base.BaseTestClass;
import org.testng.annotations.Test;

public class RejectTest extends BaseTestClass {

    public RejectTest(){
    }

    @Test
    public void RejectTestMethod() throws InterruptedException {
        reject.Reject();
    }
}
