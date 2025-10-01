package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage extends BasePage {
    public OverViewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogOutLinkDisplayed() {
        return getWebElementSize(By.cssSelector("a[href='logout.htm']")) > 0;
    }
}
