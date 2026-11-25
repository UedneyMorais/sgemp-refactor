/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Notebook
 */
public class Gravar {
    public static void main (String [] args){
        
        try {
            FileOutputStream arquivo = new FileOutputStream("log.txt");
            PrintWriter pr = new PrintWriter(arquivo);
            pr.println("teste");
            pr.println("teste2");
            pr.close();
            arquivo.close();
            
        } catch (Exception e) {
            System.err.println("ERRO: "+e);
        }
    }
}
