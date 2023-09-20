package com.store.testcases;

import com.store.pageobject.LoginPage;
import com.store.utilities.ListenerClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class TC_1  extends  BaseClass{

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
