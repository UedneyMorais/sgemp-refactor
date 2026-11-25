package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

    public static String read(String caminho) {
        String conteudo = "";

        try {
            FileReader arc = new FileReader(caminho);
            BufferedReader lerArc = new BufferedReader(arc);
            String linha = "";
            try {
                linha = lerArc.readLine();
                while (linha != null) {
                    conteudo += linha;
                    linha = lerArc.readLine();
                }
                arc.close();
            } catch (IOException e) {
                conteudo = "Erro: Não foi possível ler o arquivo!";
            }
        } catch (FileNotFoundException e) {
            conteudo = "Erro: Arquivo não encontrado!";
        }
        if (conteudo.contains("Erro")) {
            return "";
        } else {
            return conteudo;
        }
    }
        public static boolean Write(String Caminho, String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
