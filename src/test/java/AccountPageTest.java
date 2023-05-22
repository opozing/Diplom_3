import io.qameta.allure.junit4.DisplayName;
import org.example.api.ApiMethods;
import org.example.api.CreateUserPojo;
import org.example.pageobject.AccountPage;
import org.example.pageobject.HeaderPage;
import org.example.pageobject.LoginPage;
import org.example.random.RandomGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AccountPageTest {
    private WebDriver driver;
    private String token;
    private String random;
    private ApiMethods apiMethods;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private AccountPage accountPage;

    @Before
    public void setUp() {
        random = RandomGenerator.getRandom();
        apiMethods = new ApiMethods();
//        System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
    }

    @After
    public void tearDown() {
        apiMethods.deleteUser(token);
        driver.quit();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void canGoToAccountPage() {
        CreateUserPojo createUserJson = new CreateUserPojo(random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        accountPage = new AccountPage(driver);

        token = apiMethods.createUser(createUserJson);
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        headerPage.clickEnterPersonalAccountButton();
        Assert.assertTrue(accountPage.isAccountMessageVisible());
    }

    @Test
    @DisplayName("Выход из аккаунта в личном кабинете")
    public void canLogoutFromAccountPage() {
        CreateUserPojo createUserJson = new CreateUserPojo(random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        accountPage = new AccountPage(driver);

        token = apiMethods.createUser(createUserJson);
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        headerPage.clickEnterPersonalAccountButton();
        accountPage.clickExitButton();
        headerPage.clickEnterPersonalAccountButton();
        Assert.assertTrue(loginPage.isLoginButtonVisible());
    }
}
