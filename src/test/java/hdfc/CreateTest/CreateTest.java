package hdfc.CreateTest;

import hdfc.base.BaseTestClass;
import org.testng.annotations.Test;

public class CreateTest extends BaseTestClass {

    public CreateTest() {
    }

    @Test
    public void CreateTestClassMethod() throws InterruptedException {
        pr.PRCreate();
        pr.itemAdd();
        pr.ADDITIONALDETAILS();

    }

}
