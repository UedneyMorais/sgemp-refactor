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
public class HashMd5Test {
/* ==========================================================================
 * Padrão AAA (Arrange, Act, Assert)
 * ========================================================================== */

/* --- 1. Arrange (Organizar) -----------------------------------------------
 * Prepara o cenário para o teste: instancia a classe testada,
 * cria objetos de entrada, configura mocks e define valores. */


/* --- 2. Act (Agir) --------------------------------------------------------
 * Executa a ação ou chama o método que está sendo testado. */


/* --- 3. Assert (Afirmar) --------------------------------------------------
 * Verifica se o resultado obtido corresponde ao esperado. */
//==========================================================================//

private static final String HASH_ATUAL_DE_ABC = "90150983cd24fb0d6963f7d28e17f72";
   
    @Test
     void deveRetornarHashSemZeroDoByteBaixo_quandoEntradaEAbc() {
        // Arrange: prepara a entrada
        String entrada = "abc";
        
        // Act: chama o que está sendo testado
        String hashGerado = HashMd5.HashMd5(entrada);
        
         // Assert: confere o resultado
         assertEquals(HASH_ATUAL_DE_ABC, hashGerado);
        
    }
     
     @Test
     void deveRetornar31Caracteres_quandoEntradaEAbc(){
         
         String entrada = "abc";
         
         String hashGerado = HashMd5.HashMd5(entrada);
         
         assertEquals(31, hashGerado.length());
         
     }


}
