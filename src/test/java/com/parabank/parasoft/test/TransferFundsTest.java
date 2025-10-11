package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {
    @Test
    public void transferFundsV1ShouldSucceed() {
        LoginPage loginPg = pg.goTo(LoginPage.class);

        OverViewPage overViewPg = loginPg
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overViewPg.isLogOutLinkDisplayed());

        TransferFundsPage openNewAccountPg = overViewPg
                .clickTransferFundsLink();

        int amount = 1000;
        TransferCompletePage transferCompletePg = openNewAccountPg
                .fillAmount(amount)
                .selectFromAccount(0)
                .selectToAccount(0)
                .clickTransferButton();

        Assert.assertTrue(transferCompletePg.isTransferComplete(amount));
    }

    @Test
    public void transferFundsV2ShouldSucceed() {
        int amount = 1000;
        TransferCompletePage transferCompletePg = pg.goTo(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickTransferFundsLink()
                .fillAmount(amount)
//                .selectFromAccount(1)
//                .selectToAccount(1)
                .clickTransferButton();
        Assert.assertTrue(transferCompletePg.isTransferComplete(amount));
    }
}
