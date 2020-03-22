package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DocumentationPageStepDefs {



    public WebDriver driver;
    public static final Logger LOGGER = LogManager.getLogger(DocumentationPageStepDefs.class);
    //WebDriverWait wait = new WebDriverWait(driver,10);





    @Given("^launch url for Here website \"([^\"]*)\"$")
    public void launchUrlForHereWebsite(String url) throws Throwable {

        System.setProperty("webdriver.gecko.driver","C:\\drive\\installation\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        if (System.getProperty("os.name").contains("Windows")){
            driver.get(url.toString().replaceAll("/", "\\\\"));
        }

    }

    @Then("^Navigate to Documentation page$")
    public void navigateToDocumentationPage() throws Throwable{

        LOGGER.info("Step Defs: Navigating to Doc page");
        navigateToDocumentPage();

    }


    public void navigateToDocumentPage() throws Throwable{

        LOGGER.info("Navigating to Document Page");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@class='menu-list-item menu-list-item--primary has-flyout binded']" +
                "//a[@class='menu-link menu-link--primary']//span[@class='link-content'][contains(text(),'Documentation')]")).click();
        Thread.sleep(5000);
    }

    @Then("^verify active Documentation link in Documentaion page$")
    public void verifyActiveDocumentationLinkInDocumentaionPage() {

        LOGGER.info("separate out the Documention links and verify");
        List<WebElement> docLinks = driver.findElements(By.linkText("a"));
        System.out.println(docLinks);
    }
}
