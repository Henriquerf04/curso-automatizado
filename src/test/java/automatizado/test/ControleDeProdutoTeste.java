package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTeste extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleDeProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controleDeProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }
    
    // @Test
    // public void TC001_deveManterNaMesmaPaginaAoClicarEmControleDeProdutos(){
    //     controleDeProdutoPage.buttonControleDeProdutos.click();

    //     String tituloNav = controleDeProdutoPage.buttonControleDeProdutos.getText();

    //     assertEquals(tituloNav, "Controle de produtos");
    // }

    // @Test
    // public void TC002_deveVoltarParaPaginaDeLoginAoClicarEmVoltar(){
    //     controleDeProdutoPage.buttonVoltar.click();

    //     String tituloNav = controleDeProdutoPage.buttonControleDeProdutos.getText();

    //     assertEquals(tituloNav, "Controle de produtos");
    // }

    @Test
    public void TC005_deveAbrirModalParaCadastroAoCLicarNoBotaoCriar(){
        controleDeProdutoPage.buttonCriar.click();
        // TODO: Remover clique adicional assim que o sistema for corrigido.
        controleDeProdutoPage.buttonCriar.click();

        String titulo = controleDeProdutoPage.titleModal.getText();

        assertEquals(titulo, "Produto");
        controleDeProdutoPage.buttonSair.click();
        // TODO: Remover clique adicional assim que o sistema for corrigido.
        controleDeProdutoPage.buttonSair.click();
    }

    // @Test
    // public void TC008_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
    //     controleDeProdutoPage.buttonCriar.click();
    //     controleDeProdutoPage.buttonCriar.click();
        
    //     controleDeProdutoPage.cadastrarProduto("0001", "Batata", 25, 25.50, "");

    //     String mensagem = controleDeProdutoPage.spanMensagem.getText();

    //     assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
        
    // }

    @Test
    public void TC009_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleDeProdutoPage.buttonCriar.click();
        // controleDeProdutoPage.buttonCriar.click();
        
        // criar o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        // produto adicionado sem código
        produtoBuilder
        .adicionarCodigo("")
        .builder();
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // produto adicionado sem nome
        produtoBuilder
        .adicionarCodigo("00006")
        .adicionarNome("")
        .builder();
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());
        
        // produto adicionado sem quantidade
        produtoBuilder
        .adicionarNome("Martelo")
        .adicionarQuantidade(null)
        .builder();
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // produto adicionado sem valor
        produtoBuilder
        .adicionarQuantidade(1)
        .adicionarValor(null)
        .builder();
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        // produto adicionado sem valor
        produtoBuilder
        .adicionarValor(10.00)
        .adicionarData("")
        .builder();
        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

        controleDeProdutoPage.buttonSair.click();
        
    }
    

}
