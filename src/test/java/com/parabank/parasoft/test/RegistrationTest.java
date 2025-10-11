package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverViewPage;
import com.parabank.parasoft.pages.RegistrationPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    public void registerWithOnlyFirstShouldFail() {
        LoginPage lp = pg.goTo(LoginPage.class);

        RegistrationPage rp = lp.
                clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .clickRegisterForFail();
        Assert.assertTrue(rp.isRegisterErrorMessageDisplayed(9));

    }

    @Test
    public void registerWithOnlyFirstAndLastShouldFail() {
        LoginPage lp = pg.goTo(LoginPage.class);

        RegistrationPage rp = lp.
                clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .clickRegisterForFail();
        Assert.assertTrue(rp.isRegisterErrorMessageDisplayed(8));

    }

    @Test
    public void registerV1ShouldSucceed() {
        String username = LoremIpsum.getInstance().getTitle(2).replaceAll(" ", "");
        LoginPage lp = pg.goTo(LoginPage.class);

        RegistrationPage rp = lp.
                clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCity())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateFull())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getZipCode())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username);

        OverViewPage overViewPg = rp
                .clickRegisterButton();
        Assert.assertTrue(overViewPg.isLogOutLinkDisplayed());
    }

    @Test
    public void registerV2ShouldSucceed() {
        String username = LoremIpsum.getInstance().getTitle(2).replaceAll(" ", "");
        OverViewPage overViewPg = pg.goTo(LoginPage.class).
                clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCity())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateFull())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getZipCode())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterButton();
        Assert.assertTrue(overViewPg.isLogOutLinkDisplayed());
    }

    @Test
    public void registerV3ShouldSucceed() {

        OverViewPage overViewPg = pg.goTo(LoginPage.class).
                clickRegisterLink()
                .doRegister();
        Assert.assertTrue(overViewPg.isLogOutLinkDisplayed());
    }

}
