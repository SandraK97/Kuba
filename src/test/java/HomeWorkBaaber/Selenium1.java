package HomeWorkBaaber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Selenium1 {
    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/Te
stComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders
     */

    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");


        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test");

        WebElement logInButton=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        Thread.sleep(2000);

        String actualTitle2=driver.getTitle();
        String expectedTitle2="Web Orders";
        Assert.assertEquals(actualTitle2,expectedTitle2);

        WebElement header=driver.findElement(By.xpath("//h2[contains(text(),'List of All')]"));
        String headerText=header.getText().trim();
        String expectedHeader="List of All Orders";
        Assert.assertEquals(headerText,expectedHeader);

    }

    @Test
    public void test2() throws InterruptedException {
        /*
        Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");


        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test");

        WebElement logInButton=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        Thread.sleep(2000);

        WebElement allProducts= driver.findElement(By.linkText("View all products"));
        allProducts.click();
        Thread.sleep(1000);

        WebElement header=driver.findElement(By.xpath("//h2[contains(text(),'List of Products')]"));
        String actualHeader= header.getText().trim();
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("Products"));

    }

    @Test
    public void test3() throws InterruptedException {

/*
Navigate to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"
 */
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");


        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test");

        WebElement logInButton=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        Thread.sleep(2000);


        WebElement allOrdersLink=driver.findElement(By.linkText("View all orders"));
        String actualLink1 = allOrdersLink.getAttribute("href");
        System.out.println(actualLink1);
        String expectedLink1="Default.aspx";
        Assert.assertTrue(actualLink1.contains(expectedLink1));

        WebElement allProductsLink=driver.findElement(By.linkText("View all products"));
        String actualLink2=allProductsLink.getAttribute("href");
        String expectedLink2="Products.aspx";
        Assert.assertTrue(actualLink2.contains(expectedLink2));

        WebElement orderLink= driver.findElement(By.linkText("Order"));
        String actualLink3=orderLink.getAttribute("href");
        String expectedLink3="Process.aspx";
        Assert.assertTrue(actualLink3.contains(expectedLink3));

    }

    @Test
    public void test4() throws InterruptedException {
        /*
        Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");


        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test");

        WebElement logInButton=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        Thread.sleep(2000);

        WebElement orderLink= driver.findElement(By.linkText("Order"));
        orderLink.click();

        Thread.sleep(2000);
        WebElement product= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productDropDown=new Select(product);
        productDropDown.selectByVisibleText("ScreenSaver");

        WebElement quantity=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");

        WebElement custName= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        custName.sendKeys("CodeFish IT School");

        WebElement street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");

        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");

        WebElement zip= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");

        WebElement masterCardButton= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCardButton.click();

        WebElement cardNumber=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");

        WebElement expDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("03/24");


        WebElement processBtn= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processBtn.click();
        Thread.sleep(3000);

        WebElement successMssg= driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));
        String actualMssg=successMssg.getText().trim();
        String expectedMssg="New order has been successfully added.";
        Assert.assertEquals(actualMssg,expectedMssg);

        WebElement viewOrdersBtn= driver.findElement(By.linkText("View all orders"));
        viewOrdersBtn.click();
        Thread.sleep(2000);

        List <WebElement> names=driver.findElements(By.xpath("//html//body//tr//td//div//table//tbody//tr//td"));


        List<String> list1=new ArrayList<>();


        for (int i =1;i<names.size();i++){

            list1.add(names.get(i).getText().trim());


        }



        for (int i =0; i< list1.size(); i++){

            if(list1.get(i).contains("CodeFish IT School")){

                System.out.println(list1.get(i));
                break;
            }






        }










    }
}
