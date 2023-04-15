import io.qameta.allure.junit4.DisplayName;
import org.example.api.ApiMethods;
import org.example.api.CreateUserPojo;
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
    private ApiMethods apiMethods;
    private String token;


    @Before
    public void setUp() {
        random = RandomGenerator.getRandom();
        apiMethods = new ApiMethods();
//        System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
    }

    @After
    public void tearDown() {
        driver.quit();
        apiMethods.deleteUser(token);
    }

    @Test
    @DisplayName("Авторизация со страницы Конструктор")
    public void canLoginFromConstruktorPage() {
        CreateUserPojo createUserJson = new CreateUserPojo(random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        loginPage = new LoginPage(driver);
        construktorPage = new ConstruktorPage(driver);

        token = apiMethods.createUser(createUserJson);
        construktorPage.clickLoginButton();
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Авторизация из шапки сайта")
    public void canLoginFromHeaderPage() {
        CreateUserPojo createUserJson = new CreateUserPojo (random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        loginPage = new LoginPage(driver);
        construktorPage = new ConstruktorPage(driver);
        headerPage = new HeaderPage(driver);

        token = apiMethods.createUser(createUserJson);
        headerPage.clickEnterPersonalAccountButton();
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Авторизация со страницы регистрации")
    public void canLoginFromRegistrationPage() {
        CreateUserPojo createUserJson = new CreateUserPojo (random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        construktorPage = new ConstruktorPage(driver);
        headerPage = new HeaderPage(driver);

        token = apiMethods.createUser(createUserJson);
        registrationPage.clickLoginButton();
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Авторизация со страницы Восстановления пароля")
    public void canLoginFromForgotPassPage() {
        CreateUserPojo createUserJson = new CreateUserPojo (random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        loginPage = new LoginPage(driver);
        forgotPassPage = new ForgotPassPage(driver);
        construktorPage = new ConstruktorPage(driver);

        token = apiMethods.createUser(createUserJson);
        forgotPassPage.clickLoginButton();
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }
}
