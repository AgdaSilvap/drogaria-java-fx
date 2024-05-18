
package model.produto;

import java.sql.Date;

public class Produto {
    private Integer id;
    private String nome_prod;
    private Date validade;
    private String fabricante;
    private Double preco;
    
    public Produto(){
    }
    
    public Produto(String nome_prod, Date validade, String fabricante, Double preco){
        this.nome_prod = nome_prod;
        this.validade = validade;
        this.fabricante = fabricante; 
        this.preco = preco;
    }
    
    public Produto(Integer id, String nome_prod, Date validade, String fabricante, Double preco){
        this.id = id;
        this.nome_prod = nome_prod;
        this.validade = validade;
        this.fabricante = fabricante; 
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome_prod;
    }

    public void setNome(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
    
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
   
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }

}

