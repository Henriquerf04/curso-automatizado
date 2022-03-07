package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

// GoogleTest é filho de BaseTest = acessa tudo que não é privado do BaseTest (Base Modelo)
public class GoogleTest extends BaseTest {    
    
    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossívelPesquisarnoGoogleOTextoBatataFrita(){
        
        googlePage.pesquisar("Batata Frita");                      // chama a função pesquisar do GooglePO

        String resultado = googlePage.obterResultadoDaPesquisa();  // chama a função obterResultadoDaPesquisa do GooglePO
        
        assertTrue(resultado, resultado.contains("Aproximadamente"));   // teste: resultado contém "Aproximadamente"

    }

    @Test
    public void TC002_deveSerPossívelPesquisarnoGoogleOTextoNutella(){
        
        googlePage.pesquisar("Nutella");             

        String resultado = googlePage.obterResultadoDaPesquisa();  
        
        assertTrue(resultado, resultado.contains("resultados"));   // teste: resultado contém "resultados"

    }


}
