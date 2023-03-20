import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SistemaTest {

    private WebDriver webDriver;

    @BeforeAll
    public void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    public void inicio() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void abrirPagina() {
        webDriver.get("www.gov.br/pt-br");
//        Assertions.assertEquals("www.gov.br/pt-br", webDriver.getCurrentUrl());

    }

    @Test
    public void findElementbyClassTest() {
        webDriver.get("www.gov.br/pt-br");
        WebElement botao = webDriver.findElement(By.className("signed-out"));
        botao.click();
        Assertions.assertEquals("sso.acesso.gov.br/login?client_id=www.gov.br&autorization_id=181529e84bd", webDriver.getCurrentUrl());
    }

    @Disabled
    public void findElementPerfis() {

    }
}
