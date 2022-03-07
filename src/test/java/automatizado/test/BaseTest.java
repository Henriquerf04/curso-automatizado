package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste
 */
public abstract class BaseTest {         // classe abstrata = classe não pode ser instanciada, somente herdada

    /** Driver do navegador da página atual */  
    protected static WebDriver driver; // classe protegida = só pode ser vista por ela e por seus filhos

    /** Caminho base da URL do sistema a ser testado */
    private static final String URL_BASE = "file:///C:/Users/henri/OneDrive/Desktop/CURSO%20TESTES%20AUTOMATIZADOS/sistema/login.html"; // classe privada só pode ser acessada no BaseTest
    
    /** Caminho relativo do driver do projeto referente ao path */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v98.0.4758.exe";


    /** 
     * Método para iniciar o driver do navegador antes de qualquer classe de teste 
    */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();          // inicia navegador
        driver.manage().window().maximize();  // maximiza a janela
        driver.get(URL_BASE);                 // vai pra URL
    }

    /** 
     * Método que finaliza o driver do navegador depois de qualquer classe de teste
    */
    @AfterClass                       
    public static void finalizar(){
        driver.quit();
    }
            

}
