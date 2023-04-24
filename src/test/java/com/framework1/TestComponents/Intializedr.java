package com.framework1.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework1.pageobject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Intializedr {

    WebDriver driver;

    @BeforeSuite
    public WebDriver Intializedriver() throws IOException { //"D:\\chrome downloads\\selenium_career_pro\\src\\test\\java\\com\\framework1\\TestComponents\\browser.properties"


        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\chrome downloads\\selenium_career_pro\\src\\test\\java\\com\\framework1\\TestComponents\\browser.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser")!=null?System.getProperty("browser"): prop.getProperty("browser");
        if(browserName.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("headless");
//            options.setAcceptInsecureCerts(true);
            System.setProperty("webdriver.chrome.driver", "D:\\Standalone server\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        return driver;
    }

    public String getScreenShot(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file= new File(System.getProperty("user.dir")+"//reports"+ testName+"//.png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports"+ testName+"//.png";
    }

    public void CaptureScreenShot(String fileName){
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(sourcefile);
        File destfile = new File(".//ScreenShots/img1.jpg"+fileName);
        System.out.println(destfile);
        try {
            FileUtils.copyFile(sourcefile,destfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screen shot saved");

    }

    @BeforeTest
   public LoginPage Landingpg() throws IOException {
        //driver= Intializedriver();

       driver.manage().window().maximize();
        LoginPage pg = new LoginPage(driver);
        pg.navigate("https://rahulshettyacademy.com/client/");

        return pg;

   }
   @AfterTest
    public void Teardown(){
        driver.quit();
    }

   public List<HashMap<String, String>> readJSON() throws IOException {

      String jsonContent= FileUtils.readFileToString(new File("D:\\chrome downloads\\selenium_career_pro\\src\\test\\java\\com\\framework1\\TestComponents\\data.json"), StandardCharsets.UTF_8);
       ObjectMapper mapper = new ObjectMapper();
       List<HashMap<String, String>> map = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
       });
       return map;
   }
}
