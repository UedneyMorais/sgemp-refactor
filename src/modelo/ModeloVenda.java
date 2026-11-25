package modelo;

public class ModeloVenda {
    private int idVenda;
    private String dtVenda;
    private Double qtde;
    private Double valorVenda;
    private String nomeCliente;
    private int idProd;
    private Double qtdeItem;
    private Double vlTotItem;
    private float vltotal;

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the dtVenda
     */
    public String getDtVenda() {
        return dtVenda;
    }

    /**
     * @param dtVenda the dtVenda to set
     */
    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }

    /**
     * @return the valorVenda
     */
    public Double getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the nomeProduto
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setIdProd(int nomeProduto) {
        this.idProd = nomeProduto;
    }

    /**
     * @return the qtdeItem
     */
    public Double getQtdeItem() {
        return qtdeItem;
    }

    /**
     * @param qtdeItem the qtdeItem to set
     */
    public void setQtdeItem(Double qtdeItem) {
        this.qtdeItem = qtdeItem;
    }

    /**
     * @return the vltotal
     */
    public float getVltotal() {
        return vltotal;
    }

    /**
     * @param vltotal the vltotal to set
     */
    public void setVltotal(float vltotal) {
        this.vltotal = vltotal;
    }

    /**
     * @return the qtde
     */
    public Double getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(Double qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the vlTotItem
     */
    public Double getVlTotItem() {
        return vlTotItem;
    }

    /**
     * @param vlTotItem the vlTotItem to set
     */
    public void setVlTotItem(Double vlTotItem) {
        this.vlTotItem = vlTotItem;
    }
    
}
