package de.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import de.sconto.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginSteps {

    HomePage home;
    LoginPage login;
    ProfilePage profile;

    @Given("User is on Home Page")
    public void is_on_HomePage() {
        home = open("https://www.sconto.de", HomePage.class);
        getWebDriver().manage().window().maximize();
        home.acceptCookies();
    }

    @When("User clicks on Login icon")
    public void click_on_Login_icon() {
        home.clickOnLoginIcon();
    }

    @And("User enters valid data")
    public void enter_valid_data() {
        login = Selenide.page(LoginPage.class);
        login.enterData("manuel@gmail.com","Manuel12345!");
    }

    @And("User clicks on Anmelden button")
    public void click_on_Anmelden() {
        login.clickOnAnmelden();
    }

    @And("User clicks on User status")
    public void click_on_User_status() {
        home = Selenide.page(HomePage.class);
        home.clickOnUserStatus();
    }

    @Then("User verifies his name is displayed")
    public void verify_User_name() {
        profile = Selenide.page(ProfilePage.class);
        profile.verifyUserName("Manuel Neuer");
    }
}
