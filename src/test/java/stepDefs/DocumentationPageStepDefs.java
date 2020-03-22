package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DocumentationPageStepDefs {



    public WebDriver driver;
    public static final Logger LOGGER = LogManager.getLogger(DocumentationPageStepDefs.class);


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

    @And("^verify active Documentation link in Documentaion page$")
    public void verifyActiveDocumentationLinkInDocumentaionPage() throws Throwable{

        LOGGER.info("separate out the Documention links and verify");
        List<WebElement> docLinks = driver.findElements(By.xpath("//span[@class='cta__content'][contains(text(),'Documentation')]"));
        System.out.println(docLinks.size());
        String title=null;
        String parentWindow = driver.getWindowHandle();
        String currentUrl = driver.getCurrentUrl();

        for(int i=0; i<docLinks.size(); i++){
            docLinks.get(i).click();
            Thread.sleep(4000);
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> itr = allWindowHandles.iterator();

            for(String handle : allWindowHandles)
            {
                System.out.println("Window handle - > " + handle);
                driver.switchTo().window(handle);
                Thread.sleep(4000);
                title = driver.getTitle();
                System.out.println("Page is active and title is: "+title);
                break;

            }
            driver.switchTo().window(parentWindow);
        }
        driver.get(currentUrl);
    }

    @Then("^close the browser$")
    public void closeTheBrowser() throws Throwable{

        LOGGER.info("Closing all the browser ");
        Thread.sleep(3000);
        driver.quit();
    }



    public void navigateToDocumentPage() throws Throwable{

        LOGGER.info("Navigating to Document Page");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@class='menu-list-item menu-list-item--primary has-flyout binded']" +
                "//a[@class='menu-link menu-link--primary']//span[@class='link-content'][contains(text(),'Documentation')]")).click();
        Thread.sleep(5000);
    }
}
