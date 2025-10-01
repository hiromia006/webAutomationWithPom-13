package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverViewPage;
import com.parabank.parasoft.util.BatchThirteenUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkLoginPageTittle() {
        LoginPage lp = pg.goTo(LoginPage.class);
        Assert.assertEquals(lp.getTitle(), BatchThirteenUtil.PAGE_TITLE);
    }

    @Test
    public void loginWithOutCredentialShouldFail() {
        LoginPage lp = pg.goTo(LoginPage.class);
        lp = lp
                .fillUsername("")
                .fillPassword("")
                .clickLoginForFail();
        Assert.assertTrue(lp.isLoginErrorMessageDisplayed());

    }

    @Test
    public void loginWithOutCredentialShouldFail2() {
        LoginPage lp = pg.goTo(LoginPage.class)
                .fillUsername("")
                .fillPassword("")
                .clickLoginForFail();
        Assert.assertTrue(lp.isLoginErrorMessageDisplayed());

    }

    @Test
    public void loginWithOutUsernameShouldFail() {
        LoginPage lp = pg.goTo(LoginPage.class)
                .fillPassword("ssasasa")
                .clickLoginForFail();
        Assert.assertTrue(lp.isLoginErrorMessageDisplayed());

    }

    @Test
    public void loginWithOutPasswordShouldFail() {
        LoginPage lp = pg.goTo(LoginPage.class)
                .fillUsername("sasadsa")
                .clickLoginForFail();
        Assert.assertTrue(lp.isLoginErrorMessageDisplayed());

    }

    @Test
    public void loginShouldSucceed() {
        LoginPage lPage = pg.goTo(LoginPage.class);
        lPage = lPage
                .fillUsername("sqa1")
                .fillPassword("sqa1");

        OverViewPage viewPage = lPage
                .clickLoginBtn();
        Assert.assertTrue(viewPage.isLogOutLinkDisplayed());
    }

    @Test
    public void loginShouldSucceed2() {
        OverViewPage viewPage = pg.goTo(LoginPage.class)
                .fillUsername("sqa1")
                .fillPassword("sqa1")
                .clickLoginBtn();

        Assert.assertTrue(viewPage.isLogOutLinkDisplayed());
    }

}
