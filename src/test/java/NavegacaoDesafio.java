import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavegacaoDesafio {

    //Um teste com a navegação até o site do Google.
    @Test
    public void abrirNavegadorGoogle(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.quit();
    }

    @Test
    public void abrirNavegadorFirefox(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\geckodriver-v0.30.0\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com/");
        driver.quit();
    }

    //Um teste com a navegação até o site do Google com asserção se realmente o teste se encontra na página do Google.
    @Test
    public void verificarTituloPagina(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        String TituloAtual = driver.getTitle();
        String TituloEsperado = "Google";
        Assert.assertEquals(TituloEsperado,TituloAtual);
        driver.quit();
    }

    //Um teste com a navegação até o site do Google com asserção de link correto do site do Google.
    @Test
    public void verificarLinkDaPagina(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        String URLAtual = driver.getCurrentUrl();
        String URLEsperado = "https://www.google.com/";
        Assert.assertEquals(URLEsperado,URLAtual);
        driver.quit();
    }
}
