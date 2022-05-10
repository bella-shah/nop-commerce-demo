package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void initialize() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterTxt("Register");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterBtn();
        registerPage.verifyFirstNameErrorMsg("First name is required.");
        registerPage.verifyLastNameErrorMsg("Last name is required.");
        registerPage.verifyEmailErrorMsg("Email is required.");
        registerPage.verifyPasswordErrorMsg("Password is required.");
        registerPage.verifyConfirmPasswordErrorMsg("Password is required.");
    }

    @Test(groups = {"sanity", "regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        homePage.clickOnRegisterLink();
        Thread.sleep(3000);
        registerPage.selectGender("Female");
        registerPage.enterFirstName("Bella");
        registerPage.enterLastName("Shah");
        registerPage.selectDateOfBirth("5", "July", "1982");
        registerPage.enterEmail(getRandomEmail());
        registerPage.enterPassword("Bella1234");
        registerPage.enterConfirmPassword("Bella1234");
        registerPage.clickOnRegisterBtn();
        registerPage.verifyRegistrationCompletedMsg("Your registration completed");
    }
}


