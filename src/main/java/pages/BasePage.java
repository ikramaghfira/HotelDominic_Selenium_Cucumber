package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    protected Date date;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click (WebElement element){
        waitVisibility(element);
        element.click();
    }

    public BasePage writeText(WebElement element, String text){
        waitVisibility(element);
        element.sendKeys(text);
        return this;
    }

    public String readText (WebElement element){
        waitVisibility(element);
        String text = element.getText();
        return text;
    }

    public BasePage verifyTextEqual(WebElement element, String text){
        waitVisibility(element);
        String actualText = element.getText();
        Assert.assertEquals(text, actualText.toLowerCase());
        return this;
    }

    public BasePage selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    public BasePage clickRadioButton(WebElement element1, WebElement element2, int index){
        if(index==1){
            element1.click();
        } else if(index==2){
            element2.click();}
        return this;
    }

    public BasePage clickCheckButton(WebElement element1, WebElement element2, String text){
        if(text.equals("both")){
            element1.click();
            element2.click();
        } else if(text.equals("newsletter")){
            element1.click();
        } else {
            element2.click();}

        return this;
    }

    public String readInputEmail(WebElement element){
        String actualEmail = readText(element);
        return actualEmail;
    }

    public BasePage scrollTo(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public BasePage verifyInvisible(WebElement element){
        boolean isInvisible = element.isDisplayed();
        Assert.assertFalse(isInvisible);
        return this;
    }

    public BasePage verifyColorChange(WebElement element){
        Boolean isDisplayed = element.getCssValue("border").contains("rgb");
        Assert.assertTrue(isDisplayed);
        return this;
    }





}
