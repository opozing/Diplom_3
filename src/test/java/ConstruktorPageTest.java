import io.qameta.allure.junit4.DisplayName;
import org.example.pageobject.ConstruktorPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class ConstruktorPageTest {
    private WebDriver driver;
    private ConstruktorPage construktorPage;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход на вкладку Булки")
    public void canChoseRollsMenu() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        construktorPage = new ConstruktorPage(driver);

        construktorPage.waitCreateBurgerBunner();
        if (!construktorPage.getRollsButtonDiv().getAttribute("class").contains("current")) {
            construktorPage.clickRollsButton();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(construktorPage.getRollsButtonDiv().getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Переход на вкладку Соусы")
    public void canChoseSausesMenu() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        construktorPage = new ConstruktorPage(driver);

        construktorPage.waitCreateBurgerBunner();
        if (!construktorPage.getSausesButtonDiv().getAttribute("class").contains("current")) {
            construktorPage.clickSausesButton();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(construktorPage.getSausesButtonDiv().getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("Переход на вкладку Начинки")
    public void canChoseFillingsMenu() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        construktorPage = new ConstruktorPage(driver);

        construktorPage.waitCreateBurgerBunner();
        if (!construktorPage.getFillingsButtonDiv().getAttribute("class").contains("current")) {
            construktorPage.clickFillingsButton();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(construktorPage.getFillingsButtonDiv().getAttribute("class").contains("current"));
    }
}
