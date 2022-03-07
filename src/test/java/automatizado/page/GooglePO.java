package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")                          // definindo a barra de busca como inputPesquisa
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")                // definindo o campo de resultado de pesquisa como divResultadoPesquisa
    public WebElement divResultadoPesquisa;

    /**
     * Construtor para crianção da página do Google
     * @param driver Driver da página do Google
     */
    public  GooglePO(WebDriver driver) {
        super(driver);
    }

    /**
     * Método que irá efetuar uma pesquisa no Google, baseando no texto informado e concluindo com ENTER.
     * @param texto
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Método que retorna o resultado aproximado da pesquisa
     * @return resultado da pesquisa
     */
    public String obterResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();
    }  
}
