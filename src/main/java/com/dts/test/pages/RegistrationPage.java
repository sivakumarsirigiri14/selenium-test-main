package com.dts.test.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//*[@id='customer.firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='customer.lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='customer.address.street']")
    private WebElement address;

    @FindBy(xpath = "//*[@id='customer.address.city']")
    private WebElement city;

    @FindBy(xpath = "//*[@id='customer.address.state']")
    private WebElement state;

    @FindBy(xpath = "//*[@id='customer.address.zipCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//*[@id='customer.phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@id='customer.ssn']")
    private WebElement ssnNo;

    @FindBy(xpath = "//*[@id='customer.username']")
    private WebElement username;

    @FindBy(xpath = "//*[@id='customer.password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='repeatedPassword']")
    private WebElement repeatPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerBtn;

    @FindBy(xpath= "//*[@id='rightPanel']/h1")
    private WebElement userCreatedTitle;

    @FindBy(xpath= "//*[@id='customer.username.errors']")
    private WebElement errorMessageLabel;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

    public String registerUser(){
        return enterUserDetails(null);
    }

    public void registerUserWithUserId(String userId){
        enterUserDetails(userId);
    }

    public String getCreatedUserText(){
        return userCreatedTitle.getText();
    }

    private String enterUserDetails(String userId){
        enterText(firstName,getRandomString(5));
        enterText(lastName,getRandomString(5));
        enterText(address,getRandomString(5));
        enterText(city,getRandomString(5));
        enterText(state,getRandomString(8));
        enterText(zipCode,getRandomString(8));
        enterText(phoneNumber,getRandomNumber(10));
        enterText(ssnNo,getRandomNumber(9));
        if (userId == null || userId.isEmpty()) {
            userId=getRandomString(15);
        }
        enterText(username,userId);
        String passwordText = getRandomString(8);
        enterText(password,passwordText);
        enterText(repeatPassword,passwordText);
        clickElement(registerBtn);
        return userId;
    }

    public String getUserErrorMessage() {
        return getText(errorMessageLabel);
    }
}
