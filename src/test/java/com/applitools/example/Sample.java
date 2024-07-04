package com.applitools.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
//import com.applitools.eyes.selenium.ClassicRunner;
//import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
//import com.applitools.eyes.selenium.StitchMode;
import com.applitools.eyes.selenium.fluent.Target;
//import com.applitools.eyes.visualgrid.model.DeviceName;
//import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;

//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;

public class Sample {
    // Applitools objects to share for all tests
    private static BatchInfo batch;
    private static EyesRunner runner;
    private static Configuration suiteConfig;
    //private static ChromeDriver driver;

    // Test-specific objects
    private Eyes eyes;

    static WebDriver driver;
   
    @BeforeAll
    public static void beforeAll(){
        // Configure Chrome options, e.g., headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");

        driver = WebDriverManager.chromedriver().clearDriverCache().setup().capabilities(options).create();

        batch = new BatchInfo("CI/CD integration");
        runner = new VisualGridRunner(new RunnerOptions().testConcurrency(5));
        //runner = new ClassicRunner();

        suiteConfig = new Configuration();
        suiteConfig.setApiKey("i3wJhsb1046TtKlWQW98nOlAYtzisXqW8HyhxTlj64PiIk110");
        suiteConfig.setBatch(batch);
        suiteConfig.addBrowser(1000, 600, BrowserType.CHROME);
        //suiteConfig.addBrowser(1600, 1200, BrowserType.FIREFOX);
        //suiteConfig.addBrowser(1024, 768, BrowserType.SAFARI);
        //suiteConfig.addDeviceEmulation(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT);
        //suiteConfig.addDeviceEmulation(DeviceName.Nexus_10, ScreenOrientation.LANDSCAPE);

    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        eyes = new Eyes(runner);
        eyes.setConfiguration(suiteConfig);
        eyes.open(driver, "My First Tests", testInfo.getTestMethod().get().getName(), new RectangleSize(1000, 600));
    }

    @Test
    public void integrationTestTSkkk(){
        driver.get("https://applitools.com/helloworld/?diff2");
        eyes.check(Target.window());
    }

    @AfterEach
    public void afterEach(){
        eyes.closeAsync();
    }

    @AfterAll
    public static void afterAll(){
        driver.close();
        TestResultsSummary results = runner.getAllTestResults();
        System.out.println(results);
    }
}
