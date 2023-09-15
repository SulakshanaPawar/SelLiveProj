package TestCases;

import Utilities.ListenerClass;
import com.store.pageobject.LoginPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class Verigying_FaceLogin  extends  BaseClass{

    @Test
    public void verifyFacebookLogin(){
        //open url which we already given in baseclass
        driver.get(url);
        //logger.info("url opened");

        LoginPage lp = new LoginPage(driver);
        lp.sendToUsername("mona");

        lp.sendToPassword("Mona@123");

        lp.loginClick();

    }


}
