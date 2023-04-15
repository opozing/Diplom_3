import io.qameta.allure.junit4.DisplayName;
import org.example.api.ApiMethods;
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
    private ApiMethods apiMethods;
    private String token;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        random = RandomGenerator.getRandom();
        apiMethods = new ApiMethods();
        name = random;
        email = random + "@ya.ru";
        password = random;
//        System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
    }

    @After
    public void teardown() {
        driver.quit();
        if (token != null) {
            apiMethods.deleteUser(token);
        }
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void canRegistrationUser() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage = new RegistrationPage(driver);
        construktorPage = new ConstruktorPage(driver);
        loginPage = new LoginPage(driver);

        registrationPage.registrationStep(name, email, password);
        token = apiMethods.loginUser(email, password);
        loginPage.loginStep(email, password);
        Assert.assertTrue(construktorPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Ошибка регистрации пользователя с невалидным паролем")
    public void errorMessageIfPasswordLess6Symbols() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage = new RegistrationPage(driver);

        registrationPage.registrationStep(name, email, password.substring(1));
        Assert.assertTrue(registrationPage.isPasswordErrorVisible());
    }
}
