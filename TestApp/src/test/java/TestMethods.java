import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;


public class TestMethods extends PageObject {
    private final String E_MAIL = "YOUR_MAIL";
    private final String PASSWORD = "YOUR_PASSWORD";



    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement submit_button;

    public TestMethods(WebDriver driver) {
        super(driver);
    }


    public void enterSignButton(WebDriver driver) throws  InterruptedException{
        //WebElement login=driver.findElement(By.cssSelector("#main-header > div:nth-of-type(3) > div > div > div:first-of-type > div:nth-of-type(3) > div > div:first-of-type > div"));
        WebElement log =driver.findElement(By.cssSelector("#main-header > div:nth-of-type(3) > div > div > div:first-of-type > div:nth-of-type(3) > div > div:first-of-type > div > div:nth-of-type(2)"));
        log.click();
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.cssSelector("a[data-cy='header-login-button']"));
        login.click();

    }



    public void enterMail(WebDriver driver){
        WebElement e_mail= driver.findElement(By.id("L-UserNameField"));
        e_mail.sendKeys(E_MAIL);
    }
    public void enterPassword(WebDriver driver){
        WebElement password= driver.findElement(By.id("L-PasswordField"));
        password.sendKeys(PASSWORD);
    }

    public void pressSubmitButton(WebDriver driver){
        driver.findElement(By.id("gg-login-enter")).click();
    }
    public void search(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement item = driver.findElement(By.name("k"));
        WebElement searchBar = driver.findElement(By.cssSelector("button[data-cy='search-find-button']"));
        item.sendKeys("bilgisayar");
        Thread.sleep(3000);
        searchBar.click();

    }
    public void searchSecondpage(WebDriver driver) throws InterruptedException {
        WebElement secondPage = driver.findElement(By.className("next-link"));
        WebElement x = driver.findElement(By.cssSelector("a[class='policy-alert-close btn-alert-close']"));
        x.click();
        secondPage.click();
        Thread.sleep(3000);

    }
    public void selectRandomItem (WebDriver driver) throws  InterruptedException {

        WebElement randomItem = driver.findElement(By.cssSelector("li[product-index='20']"));
        //id='product_id_675153282'
        //product-id='659881036'
        randomItem.click();
        Thread.sleep(3000);

    }
    public void addToRandomItemToBasket (WebDriver driver) throws  InterruptedException{
        WebElement addBasket = driver.findElement(By.id("add-to-basket"));
        addBasket.click();
        Thread.sleep(8000);

    }
    public void compareWithBasketAndItem(WebDriver driver) throws InterruptedException{

        String ItemPrice=driver.findElement(By.cssSelector("div[id='sp-price-lowPrice']")).getText();
        WebElement basket = driver.findElement(By.cssSelector("div[class='icon-sepet-line-wrapper']"));
        basket.click();
        Thread.sleep(3000);
        String basketPrice = driver.findElement(By.cssSelector("#cart-price-container > div:nth-of-type(3) > p")).getText();
        Assert.assertEquals(ItemPrice,basketPrice);

    }
    public void addNewTheItem(WebDriver driver) throws InterruptedException{

        WebElement elements = driver.findElement(By.xpath("//select[@class='amount']"));
        Select sel = new Select(elements);
        sel.selectByValue("2");
        WebElement selected = sel.getFirstSelectedOption();
        selected.click();
        Thread.sleep(3000);
        String controlCount =driver.findElement(By.cssSelector("div[class='gg-d-16 detail-text']")).getText();
        Assert.assertEquals("Ürün Toplamı (2 Adet)",controlCount);
    }
    public void removeTheBasket(WebDriver driver) throws InterruptedException{
        WebElement deleteItems = driver.findElement(By.cssSelector("i[class='gg-icon gg-icon-bin-medium']"));
        Thread.sleep(3000);
        deleteItems.click();
        Thread.sleep(3000);
        String check=driver.findElement(By.cssSelector("#empty-cart-container > div:first-of-type > div:first-of-type > div > div:nth-of-type(2) > p")).getText();
        Assert.assertEquals("Alışverişe devam etmek için anasayfaya gidebilir veya Günün Fırsatı ürünlerine göz atabilirsiniz.",check);

    }


}
