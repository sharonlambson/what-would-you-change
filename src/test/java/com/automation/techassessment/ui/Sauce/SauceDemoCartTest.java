package com.automation.techassessment.ui.Sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.automation.techassessment.ui.lib.Wait;
import com.automation.techassessment.ui.pages.sauce.SauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoCartTest extends BaseUITest {


    @BeforeMethod
    public void setup() {
        SauceDemo.Login.login("standard_user", "secret_sauce");
    }

    @Test
    public void addBackPackToCartTest() throws Exception {
        SauceDemo.Dashboard.backPack();
        SauceDemo.Dashboard.GoToTheShoppingCart();

        String backBackText = SauceDemo.Dashboard.getBackPackInShoppingCartText();

        Assert.assertEquals(backBackText.split(" ")[0] + " " + backBackText.split(" ")[1], "Sauce Labs");
    }
}
