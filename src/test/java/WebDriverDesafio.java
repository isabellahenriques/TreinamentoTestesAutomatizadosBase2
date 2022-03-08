import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverDesafio {

   //Um teste com navegação até o site DropDown List, e manipule o combobox para escolher um elemento.
    @Test
    public void selecionarComboUm(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");

        //Combobox
        WebElement comboOption1 = driver.findElement(By.id("dropdown"));
        Select select = new Select(comboOption1);
        select.selectByVisibleText("Option 1");

        driver.quit();
    }

    @Test
    public void selecionarComboDois(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\isabellaSzrajbman\\Desktop\\TreinamentoBase2\\drivers\\chromedriver97\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");

        //Combobox
        WebElement comboOption1 = driver.findElement(By.id("dropdown"));
        Select select = new Select(comboOption1);
        select.selectByVisibleText("Option 2");

        driver.quit();
    }
}
