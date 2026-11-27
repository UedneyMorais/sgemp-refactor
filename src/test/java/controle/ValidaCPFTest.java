/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author dev
 */
public class ValidaCPFTest {
    
    
    @ParameterizedTest
    @ValueSource(strings = {"00000000000","11111111111","22222222222","33333333333","44444444444","55555555555","66666666666","77777777777","88888888888","99999999999"})
    void deveRejeitar_quandoTodosOsDigitosSaoIguais(String cpf){   
        boolean isCPF = ValidaCPF.isCPF(cpf);
        assertEquals(false, isCPF);   
    }
    
    @Test
    void deveRetornarTrue_quandoCpfTemDigitosVerificadoresValidos(){
        String cpf = "12345678909";
        boolean isCPF = ValidaCPF.isCPF(cpf);
        assertEquals(true, isCPF);   
    }
    
    @Test
    void deveRejeitar_quandoQuantidadeDeDigitosDigitadosForMenorQue11(){
        String cpf = "2345678909";
        boolean isCPF = ValidaCPF.isCPF(cpf);
        assertEquals(false, isCPF);
    }
    
    @Test
    void deveRejeitar_quandoQuantidadeDeDigitosDigitadosForMaiorQue11(){
        String cpf = "123456789099";
        boolean isCPF = ValidaCPF.isCPF(cpf);
        assertEquals(false, isCPF);
    }
    
    @Test
    void deveRejeitar_quandoPrimeiroDigitoVerificadorEstaErrado(){
        String cpf= "12345678917";
        boolean isCPF = ValidaCPF.isCPF(cpf);
        assertEquals(false, isCPF);
    }
    
    @Test
    void deveRejeitar_quandoSegundoDigitoVerificadorEstaErrado(){
        String cpf = "12345678902";
        boolean isCPF = ValidaCPF.isCPF(cpf);
        assertEquals(false, isCPF);
    }
    
    @Test
    void deveRetornarCpfFormatado_quandoReceber11Caracteres(){
          String cpf = "12345678902";
          String cpfFormatado = ValidaCPF.imprimeCPF(cpf);
          assertEquals("123.456.789-02", cpfFormatado);
    }
    
    @Test
    void deveCausarException_quandoReceberMenosDe11Caracteres() {
        String cpf = "1234567890";
       assertThrows(StringIndexOutOfBoundsException.class, ()-> ValidaCPF.imprimeCPF(cpf)); 
    }
    
    @Test
    void deveRetornarCpfFormatado_quandoReceberMaisDe11Caracteres() {
        String cpf = "123456789099";
        String cpfFormatado = ValidaCPF.imprimeCPF(cpf);
        assertEquals("123.456.789-09", cpfFormatado);
    }
    
}
