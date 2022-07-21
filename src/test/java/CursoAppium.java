import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CursoAppium {

    private AndroidDriver driver;
    public WebDriverWait wait;

    By btnCadastrarPessoa   = By.id("button_cadastrar");
    By textInputNome        = By.id("TextInputNome");
    By textInputEmail       = By.id("TextInputEmail");
    By radioButtonMulher    = By.id("radioButton_mulher");
    By spinnerIcon          = By.id("spinner_estados");
    By btnCadastrar         = By.id("BotaoCadastrar");


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:app", "/home/mabezerr/Documents/pessoal/aulas/appium-java/src/test/java/resources/app-curso.apk");
        desiredCapabilities.setCapability("appium:appPackage", "com.example.cursoappium");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void sampleTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCadastrarPessoa)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textInputNome)).sendKeys("teste_1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(textInputEmail)).sendKeys("teste@test.com");
        driver.findElement(btnCadastrar).click();
        driver.findElement(radioButtonMulher).click();

        // TODO: adjust toast message
        //driver.findElement(By.linkText("Email já cadastrado"));
        //driver.findElement(By.partialLinkText("Email já cadastrado"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
