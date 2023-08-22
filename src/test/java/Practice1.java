
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Practice1 {

    @Test()
    public void Test1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        WebElement inputClick= driver.findElement(By.linkText("Input Form Submit"));
        inputClick.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.lambdatest.com/selenium-playground/input-form-demo";
        Assert.assertEquals(actualUrl,expectedUrl);

        WebElement name=driver.findElement(By.id("name"));
        name.sendKeys("Aleksandra");

        WebElement email=driver.findElement(By.id("inputEmail4"));
        email.sendKeys("test@gmail.com");

        WebElement password= driver.findElement(By.cssSelector("input[id=inputPassword4]"));
        password.sendKeys("tree");

        WebElement company=driver.findElement(By.cssSelector("input[id=company]"));
        company.sendKeys("Alekleks");

        WebElement webSite= driver.findElement(By.cssSelector("input[id=websitename]"));
        webSite.sendKeys("Aleksas");



        WebElement country= driver.findElement(By.cssSelector("select[name='country']"));
        country.sendKeys("Serbia");

        WebElement city= driver.findElement(By.id("inputCity"));
        city.sendKeys("BL");
        WebElement address1=driver.findElement(By.cssSelector("input[id='inputAddress1']"));
        address1.sendKeys("asf");

        WebElement address2=driver.findElement(By.cssSelector("input[id='inputAddress2']"));
        address2.sendKeys("sef");

        WebElement state=driver.findElement(By.cssSelector("input[id='inputState']"));
         state.sendKeys("IL");

         WebElement zipCode=driver.findElement(By.cssSelector("input[id='inputZip']"));
         zipCode.sendKeys("60106");

         WebElement submitButton=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
         submitButton.click();


        List<WebElement> allText=driver.findElements(By.xpath("//p"));
        for (int i =0; i<allText.size();i++){

            if (allText.get(i).getText().contains("Thanks")){
                Assert.assertEquals(allText.get(i).getText(),"Thanks for contacting us, we will get back to you shortly.");


            }


        }

    }
}
