
package model.venda;

import java.sql.Date;

public class Venda {
    private Integer id;
    private String prod_vendido;
    private Date data_venda;
    private Double valor_total;
    
    public Venda(){
    }
    
    public Venda(String prod_vendido, Date data_venda, Double valor_total){
        this.prod_vendido = prod_vendido;
        this.data_venda = data_venda; 
        this.valor_total = valor_total;
    }
    
    public Venda(Integer id, String prod_vendido, Date data_venda, Double valor_total){
        this.id = id;
        this.prod_vendido = prod_vendido;
        this.data_venda = data_venda; 
        this.valor_total = valor_total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getProduto() {
        return prod_vendido;
    }

    public void setProduto(String prod_vendido) {
        this.prod_vendido = prod_vendido;
    }

    public Date getData() {
        return data_venda;
    }

    public void setData(Date data_venda) {
        this.data_venda = data_venda;
    }
   
    public Double getValor() {
        return valor_total;
    }

    public void setValor(Double valor_total) {
        this.valor_total = valor_total;
    }
    
    @Override
    public String toString(){
        return this.getProduto();
    }

}

