package Factory;
import HDFC.Login.Login;
import HDFC.PR.PR;

public class Factory {

    Login login;
    PR pr;


    private Factory(){
    }

    public Factory(Login login,PR pr){
        this.login = login;
        this.pr = pr;
    }

    public void Name() {
        login.LoginMethod();
        pr.PRCreate();

    }




}
