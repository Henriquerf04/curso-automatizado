package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    
    //#region WebElements
    @FindBy(id = "email")                          // definindo o campo de Email como inputEmail
    public WebElement inputEmail;

    @FindBy(id = "senha")                          // definindo o campo de Senha como inputSenha
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")                     // definindo o botão Entrar como buttonEntrar
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")                       // definindo o campo Mensagem como spanMensagem
    public WebElement spanMensagem;
    //#endregion WebElements

    //#region Construtor
    /**
     * Construtor padrão para a criação de uma nova ionstância da página de login
     * @param driver Driver da página de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Construtor
    
    //#region Métodos

    /**
     * Método que obtem a mensagem disparada na tela
     * @return Texto da mensagem
     */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }

    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }
    //#endregion Métodos

}
