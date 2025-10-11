package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.BatchThirteenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferCompletePage extends BasePage {
    public TransferCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTransferComplete(int amount) {
        BatchThirteenUtil.waitForDomStable();
        return getWebElement(By.id("amountResult")).getText().contains(String.valueOf(amount));
    }
}
