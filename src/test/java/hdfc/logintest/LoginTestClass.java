package hdfc.logintest;
import hdfc.base.BaseTestClass;
import org.testng.annotations.Test;

public class LoginTestClass  extends BaseTestClass {

    public LoginTestClass() {
    }

    @Test
    public void LoginTestClassMethod() throws InterruptedException {
        login.LoginMethod();
    }
}