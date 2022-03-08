import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LocalizandoElementosDesafio {

    //Um teste com navegação no Google com pesquisa no campo de busca e asserção no retorno de resultados da pesquisa
    @Test
    public void pesquisarNoGoogle(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("treinamentoBase2" + Keys.ENTER);
        Assert.assertEquals("treinamentoBase2", driver.findElement(By.name("q")).getAttribute("value"));
        System.out.println(driver.getPageSource()); //retornou o codigo html
        driver.quit();
    }

    //Um teste com navegação até o site Filling Out Forms, com preenchimento de todos os campos obrigatórios
    //do formulário à esquerda, submeter e validar o retorno.
    @Test
    public void preencherFormularioEsquerda(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Isabella Henriques");
        driver.findElement(By.id("et_pb_contact_message_0")).sendKeys("Teste teste teste teste teste");

        WebElement botaoSubmit = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("et_builder_submit_button")));
        botaoSubmit.click();

        WebElement mensagem = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[2]/div[1]/div/div/p")));

        Assert.assertEquals("Thanks for contacting us",
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[2]/div[1]/div/div/p")).getText());

        driver.quit();
    }

    //Um teste com navegação até o site Filling Out Forms, com preenchimento de somente um campo obrigatório
    // do formulário à esquerda, submeter e validar o retorno.
    @Test
    public void preencherUmCampoFormularioEsquerda(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Isabella Henriques");

        WebElement botaoSubmit = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("et_builder_submit_button")));
        botaoSubmit.click();

        WebElement PrimeiraMensagem = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[2]/div[1]/div/div[1]/p")));

        Assert.assertEquals("Please, fill in the following fields:",
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[2]/div[1]/div/div[1]/p")).getText());

        WebElement SegundaMensagem = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[2]/div[1]/div/div[1]/ul[1]/li")));

        Assert.assertEquals("Message",
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[2]/div[1]/div/div[1]/ul[1]/li")).getText());
        driver.quit();

    }
}
