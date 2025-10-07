package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.AccountOpenedPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OpenNewAccountPage;
import com.parabank.parasoft.pages.OverViewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test
    public void openNewAccountV1ShouldSucceed() {
        LoginPage loginPg = pg.goTo(LoginPage.class);

        OverViewPage overViewPg = loginPg
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overViewPg.isLogOutLinkDisplayed());

        OpenNewAccountPage openNewAccountPg = overViewPg
                .clickOpenNewAccountLink();

        AccountOpenedPage accountOpenedPg = openNewAccountPg
                .selectAccountType(1)
                .clickOpenNewAccountButton();
        Assert.assertTrue(accountOpenedPg.hasAccountOpenedId());

    }

    @Test
    public void openNewAccountV2ShouldSucceed() {
        AccountOpenedPage accountOpenedPg =  pg.goTo(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenNewAccountButton();
        Assert.assertTrue(accountOpenedPg.hasAccountOpenedId());

    }

}
