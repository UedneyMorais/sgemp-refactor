package modelo;

/**
 *
 * @author Notebook
 */
public class ModeloOrcamento {
  private int id;
  private int codCli;
  private int codProd;
  private String cpf;
  private String descricao;
  private String dtIniorc;
  private String dtFimorc;
  private double valor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codCli
     */
    public int getCodCli() {
        return codCli;
    }

    /**
     * @param codCli the codCli to set
     */
    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    /**
     * @return the codProd
     */
    public int getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the dtIniorc
     */
    public String getDtIniorc() {
        return dtIniorc;
    }

    /**
     * @param dtIniorc the dtIniorc to set
     */
    public void setDtIniorc(String dtIniorc) {
        this.dtIniorc = dtIniorc;
    }

    /**
     * @return the dtFimorc
     */
    public String getDtFimorc() {
        return dtFimorc;
    }

    /**
     * @param dtFimorc the dtFimorc to set
     */
    public void setDtFimorc(String dtFimorc) {
        this.dtFimorc = dtFimorc;
    }
    
}
