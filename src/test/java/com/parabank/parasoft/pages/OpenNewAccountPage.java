package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewAccountPage selectAccountType(int index) {
        getSelect(By.cssSelector("select[id='type']")).selectByIndex(index);
        return this;
    }

    public OpenNewAccountPage selectFromAccount(int index) {
        getSelect(By.id("fromAccountId")).selectByIndex(index);
        return this;
    }

    public AccountOpenedPage clickOpenNewAccountButton() {
        clickElement(By.cssSelector("input[value='Open New Account']"));
        return goTo(AccountOpenedPage.class);
    }
}
