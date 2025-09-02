package de.sconto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @FindBy(css = "[data-accept-action='all']")
    WebElement acceptAll;

    public HomePage acceptCookies() {
        if ($(acceptAll).exists()) {
            $(acceptAll).click();
        }
        return Selenide.page(this);
    }

    public LoginPage clickOnLoginIcon() {
        $(".headerElement__icon--login").click();
        return Selenide.page(LoginPage.class);
    }

    public ProfilePage clickOnUserStatus() {
        $(".headerElement__status--login").shouldBe(Condition.visible).click();
        return Selenide.page(ProfilePage.class);
    }

    public ItemPage clickOnCategory(String category) {
        $(".ccm-flexbox-flex1:nth-child(" + category + ")").shouldBe(Condition.visible).click();
        return Selenide.page(ItemPage.class);
    }
}
