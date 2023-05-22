import io.qameta.allure.junit4.DisplayName;
import org.example.api.ApiMethods;
import org.example.api.CreateUserPojo;
import org.example.pageobject.ConstruktorPage;
import org.example.pageobject.HeaderPage;
import org.example.pageobject.LoginPage;
import org.example.random.RandomGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HeaderPageTest {
    private WebDriver driver;
    private String token;
    private String random;
    private ApiMethods apiMethods;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private ConstruktorPage construktorPage;

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
    @DisplayName("Переход на страницу Конструктор по кнопке")
    public void canGoToConstruktorPageByButton() {
        CreateUserPojo createUserJson = new CreateUserPojo(random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        construktorPage = new ConstruktorPage(driver);

        token = apiMethods.createUser(createUserJson);
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        headerPage.clickEnterPersonalAccountButton();
        headerPage.clickConstruktorButton();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Переход на страницу Конструктор по логотипу")
    public void canGoToConstruktorPageByLogo() {
        CreateUserPojo createUserJson = new CreateUserPojo(random + "@ya.ru", random, random);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        construktorPage = new ConstruktorPage(driver);

        token = apiMethods.createUser(createUserJson);
        loginPage.loginStep(createUserJson.getEmail(), createUserJson.getPassword());
        headerPage.clickEnterPersonalAccountButton();
        headerPage.clickMainLogo();
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }
}
