import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestClass {
    private static final Logger logger = LogManager.getLogger(TestClass.class);



    private static final WebDriver driver = new ChromeDriver();

    @Before
    public  void setupDriver() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        logger.info("The Home Page is opened.");

    }

    @Test
    public  void startTest() throws InterruptedException {

        TestMethods test= new TestMethods(driver);
        test.enterSignButton(driver);
        logger.info("The Sign Up page is opened.");
        test.enterMail(driver);
        test.enterPassword(driver);
        test.pressSubmitButton(driver);
        logger.info("Signing Up is successful.");
        test.search(driver);
        logger.info("Searching is successful.");
        test.searchSecondpage(driver);
        logger.info("Switching to second page is successful.");
        test.selectRandomItem(driver);
        logger.info("Selecting random product from second page is successful.");
        test.addToRandomItemToBasket(driver);
        logger.info("Adding the selected random product to the basket is successful.");
        test.compareWithBasketAndItem(driver);
        logger.info("Price comparison between the basket and product is successful.");
        test.addNewTheItem(driver);
        logger.info("Changing the count of the product which  was added to the basket, to two.");
        test.removeTheBasket(driver);
        logger.info("The all products which are in basket, are removed.The test is finished successfully.");

    }

    @After
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().deleteAllCookies();
        driver.close();
    }
}