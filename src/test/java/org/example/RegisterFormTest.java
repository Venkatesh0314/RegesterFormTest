package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterFormTest {
    public static void main(String[] args){
        try {
            WebDriverManager.chromedriver().setup();
            // open the driver
            WebDriver driver=new ChromeDriver();
            // maximize the window
            driver.manage().window().maximize();
            // open the url
            driver.get("https://qaregform.ccbp.tech");
            // enter the firstname as input
            WebElement firstName=driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
            firstName.sendKeys("John");
            // enter the lastName as input
            WebElement lastName=driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
            lastName.sendKeys("Doe");
            // click to submit the button
            WebElement submitButton=driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
            submitButton.click();

            // wait 10 seconds
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            // check test display
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/p")));
            //current text displayText
            WebElement driverFind=driver.findElement(By.xpath("/html/body/div/div/div/p"));
            String textRetrive=driverFind.getText();
            // expected text
            String expectedTextWin="Submitted Successfully";

            // if condition check
            if(expectedTextWin.equals(textRetrive)){
                System.out.println("Registration Successful");
            }else{
                System.out.println("Registration is failed");
            }
            WebElement SubmitAnotherText=driver.findElement(By.xpath("/html/body/div/div/div/button"));
            // click the button
            SubmitAnotherText.click();
            // close the driver
            driver.close();


        }catch (Exception e){
            System.out.println("Hi venkatesh we got an Exception error:"+e);
        }
    }

}
