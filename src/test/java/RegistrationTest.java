import org.example.pageobject.ConstruktorPage;
import org.example.pageobject.LoginPage;
import org.example.random.RandomGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pageobject.RegistrationPage;


public class RegistrationTest {
    private WebDriver driver;
    private String random;
    private RegistrationPage registrationPage;
    private ConstruktorPage construktorPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        random = RandomGenerator.getRandom();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void canRegistrationUser() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage = new RegistrationPage(driver);
        construktorPage = new ConstruktorPage(driver);
        loginPage = new LoginPage(driver);

        registrationPage.registrationStep(random, random + "@ya.ru", random);
        loginPage.waitOpenLoginPage();
        loginPage.loginStep(random + "@ya.ru", random);
        construktorPage.waitOpenConstruktorPage();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    public void errorMessageIfPasswordLess6Symbols() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage = new RegistrationPage(driver);

        registrationPage.registrationStep(random, random + "@ya.ru", random.substring(1));
        Assert.assertTrue(registrationPage.isPasswordErrorVisible());

    }
}
