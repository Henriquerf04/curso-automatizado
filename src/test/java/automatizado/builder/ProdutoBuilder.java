package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;

/** 
 * Classe que sabe construir um produto
 */
public class ProdutoBuilder {
    
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "05/03/2022";

    private ControleDeProdutoPO controleDeProdutoPO;

    /** Construtor do ProdutoBuilder que recebe a página ControleDeProduto */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    
    /**
     * Método que adiciona um código ao Builder
     * @param codigo Código que será adicionado
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
     * Método que adiciona um nome ao Builder
     * @param nome Nome que será adicionado
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Método que adiciona uma quantidade ao Builder
     * @param quantidade Quantidade que será adicionada
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Método que adiciona um valor ao Builder
     * @param valor Valor que será adicionado
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
     * Método que adiciona uma data ao Builder
     * @param data Data que será adicionado
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Método que constroi o produto, adiciona o produto pela tela de cadastro
     */
    public void builder(){
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : ""); // if else
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
        
        controleDeProdutoPO.buttonSalvar.click();
    }
}
