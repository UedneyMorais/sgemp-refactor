/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author uedney
 */
public class ModeloCompra {

    private int codComp;
    private String dtComp;
    private double qtdeComp;
    private double vlComp;
    private double engradComp;

    /**
     * @return the codComp
     */
    public int getCodComp() {
        return codComp;
    }

    /**
     * @param codComp the codComp to set
     */
    public void setCodComp(int codComp) {
        this.codComp = codComp;
    }

    /**
     * @return the dtComp
     */
    public String getDtComp() {
        return dtComp;
    }

    /**
     * @param dtComp the dtComp to set
     */
    public void setDtComp(String dtComp) {
        this.dtComp = dtComp;
    }

    /**
     * @return the qtdeComp
     */
    public double getQtdeComp() {
        return qtdeComp;
    }

    /**
     * @param qtdeComp the qtdeComp to set
     */
    public void setQtdeComp(double qtdeComp) {
        this.qtdeComp = qtdeComp;
    }

    /**
     * @return the vlComp
     */
    public double getVlComp() {
        return vlComp;
    }

    /**
     * @param vlComp the vlComp to set
     */
    public void setVlComp(double vlComp) {
        this.vlComp = vlComp;
    }

    /**
     * @return the engradComp
     */
    public double getEngradComp() {
        return engradComp;
    }

    /**
     * @param engradComp the engradComp to set
     */
    public void setEngradComp(double engradComp) {
        this.engradComp = engradComp;
    }
}
