import org.example.pageobject.*;
import org.example.random.RandomGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private ConstruktorPage construktorPage;
    private HeaderPage headerPage;
    private String random;
    private ForgotPassPage forgotPassPage;


    @Before
    public void setUp() {
        random = RandomGenerator.getRandom();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void canLoginFromConstruktorPage() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        construktorPage = new ConstruktorPage(driver);
        headerPage = new HeaderPage(driver);

        registrationPage.registrationStep(random, random + "@ya.ru", random);
        loginPage.waitOpenLoginPage();
        headerPage.clickMainLogo();
        construktorPage.waitOpenConstruktorPage();
        headerPage.clickAccountButton();
        loginPage.waitOpenLoginPage();
        loginPage.loginStep(random + "@ya.ru", random);
        construktorPage.waitOpenConstruktorPage();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    public void canLoginFromAccountPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        construktorPage = new ConstruktorPage(driver);
        headerPage = new HeaderPage(driver);

        registrationPage.registrationStep(random, random + "@ya.ru", random);
        loginPage.waitOpenLoginPage();
        headerPage.clickMainLogo();
        construktorPage.waitOpenConstruktorPage();
        headerPage.clickAccountButton();
        loginPage.waitOpenLoginPage();
        loginPage.loginStep(random + "@ya.ru", random);
        construktorPage.waitOpenConstruktorPage();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    public void canLoginFromRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        construktorPage = new ConstruktorPage(driver);
        headerPage = new HeaderPage(driver);

        registrationPage.registrationStep(random, random + "@ya.ru", random);
        loginPage.waitRegistrationButton();
        loginPage.clickRegistrationButton();
        registrationPage.waitOpenRegistrationPage();
        registrationPage.clickLoginButton();
        loginPage.waitOpenLoginPage();
        loginPage.loginStep(random + "@ya.ru", random);
        construktorPage.waitOpenConstruktorPage();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    public void canLoginFromForgotPassPage() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        forgotPassPage = new ForgotPassPage(driver);
        construktorPage = new ConstruktorPage(driver);

        registrationPage.registrationStep(random, random + "@ya.ru", random);
        loginPage.waitForgotPassButton();
        loginPage.clickForgotPassButton();
        forgotPassPage.waitLoginButton();
        forgotPassPage.clickLoginButton();
        loginPage.waitOpenLoginPage();
        loginPage.loginStep(random + "@ya.ru", random);
        construktorPage.waitOpenConstruktorPage();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }


}
