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
                .fillPassword(getPassword())
                .clickLoginForFail();
        Assert.assertTrue(lp.isLoginErrorMessageDisplayed());

    }

    @Test
    public void loginWithOutPasswordShouldFail() {
        LoginPage lp = pg.goTo(LoginPage.class)
                .fillUsername(getUsername())
                .clickLoginForFail();
        Assert.assertTrue(lp.isLoginErrorMessageDisplayed());

    }

    @Test
    public void loginV1ShouldSucceed() {
        LoginPage lPage = pg.goTo(LoginPage.class);
        lPage = lPage
                .fillUsername(getUsername())
                .fillPassword(getPassword());

        OverViewPage viewPage = lPage
                .clickLoginBtn();
        Assert.assertTrue(viewPage.isLogOutLinkDisplayed());
    }

    @Test
    public void loginV2ShouldSucceed() {
        OverViewPage viewPage = pg.goTo(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();

        Assert.assertTrue(viewPage.isLogOutLinkDisplayed());
    }

    @Test
    public void loginV3ShouldSucceed() {
        OverViewPage viewPage = pg.goTo(LoginPage.class)
                .doLogin(getUsername(), getPassword());

        Assert.assertTrue(viewPage.isLogOutLinkDisplayed());
    }

}
