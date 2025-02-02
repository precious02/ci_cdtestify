package org.example.Task19.Task17demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Interactions {

    WebDriver driver = null;


    @BeforeClass
    public void openBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Testify\\CI_CD_Clone\\ci_cdtestify\\Module4Bselenium\\src\\chromedriver.exe");

        //Launch browser
        driver = new ChromeDriver();

        //To Maximize the browser
        driver.manage().window().maximize();

        //Add implicit wait

        driver.get(" https://demoqa.com ");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");

        Thread.sleep(5000);

    }

    @Test
    public void demoInteractions() throws InterruptedException {
        WebElement gInterac = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[2]/*[1]"));

        gInterac.click();

        String interaction = driver.findElement(By.cssSelector(".main-header")).getText();

        Thread.sleep(3000);

        SoftAssert assertElements = new SoftAssert();

        assertElements.assertEquals(interaction, "Interaction");

        System.out.println("Interactions Page is visible ");

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
