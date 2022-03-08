import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalizandoElementosFacebookDesafio {
    WebDriver driver;

    @Before
    public void preCondicao() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/"); //Acessar a página do Facebook
        driver.manage().window().maximize(); // maximiza a janela do navegador.

        WebElement btNovaConta = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        btNovaConta.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
    }

    @Test
    public void testeNome() {
        driver.findElement(By.name("firstname")).sendKeys("Teste Primeiro Nome");
        Assert.assertEquals("Teste Primeiro Nome", driver.findElement(By.name("firstname")).getAttribute("value"));
    }

    @Test
    public void testeSobrenome() {
        driver.findElement(By.name("lastname")).sendKeys("Teste Sobrenome");
        Assert.assertEquals("Teste Sobrenome", driver.findElement(By.name("lastname")).getAttribute("value"));
    }

    @Test
    public void testeEmail() {
        driver.findElement(By.name("reg_email__")).sendKeys("teste@teste.com.br");
        Assert.assertEquals("teste@teste.com.br", driver.findElement(By.name("reg_email__")).getAttribute("value"));

        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("teste@teste.com.br");
        Assert.assertEquals("teste@teste.com.br", driver.findElement(By.name("reg_email_confirmation__")).getAttribute("value"));

    }

    @Test
    public void testeSenha() {
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456");
        Assert.assertEquals("123456", driver.findElement(By.name("reg_passwd__")).getAttribute("value"));
    }


    //Combobox
    @Test
    public void Data() {
        WebElement comboDia = driver.findElement(By.id("day"));
        Select select = new Select(comboDia);
        select.selectByVisibleText("6");
        Assert.assertEquals("6", select.getFirstSelectedOption().getText());

    }

    @Test
    public void testeMes() {
        WebElement comboMes = driver.findElement(By.id("month"));
        Select select = new Select(comboMes);
        select.selectByVisibleText("Jun");
        Assert.assertEquals("Jun", select.getFirstSelectedOption().getText());
    }

    @Test
    public void testeAno() {
        WebElement comboAno = driver.findElement(By.id("year"));
        Select select = new Select(comboAno);
        select.selectByVisibleText("1987");
        Assert.assertEquals("1987", select.getFirstSelectedOption().getText());
    }

    //RadioButton
    @Test
    public void testeFeminino() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/input")).click();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/input")).isSelected());
    }

    @After
    public void posCondicao() {
       driver.quit();
    }
}
