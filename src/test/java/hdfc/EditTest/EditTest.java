package hdfc.EditTest;

import hdfc.base.BaseTestClass;
import org.testng.annotations.Test;

public class EditTest extends BaseTestClass {

    public EditTest(){
    }

    @Test
    public void EditTestMethod() throws InterruptedException {

        edit.Edit();
        edit.EditPageAddingItem();

    }
}
