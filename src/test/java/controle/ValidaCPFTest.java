/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author dev
 */
public class ValidaCPFTest {
    
    
    @Test
    void deveRejeitar_quandoTodosOsDigitosSaoIguais(){
        String cpf = "11111111111";
        
        boolean isCPF = ValidaCPF.isCPF(cpf);
        
        assertEquals(false, isCPF);   
    }
    
     @Test
    void deveRetornarTrue_quandoCpfTemDigitosVerificadoresValidos(){
        String cpf = "12345678909";
         
        boolean isCPF = ValidaCPF.isCPF(cpf);
         
        assertEquals(true, isCPF);   
    }
    
}
