package cminado.start;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CampoTeste {
    
    private Campo campo = new Campo(3,3);

    @Test
    public void testeVizinhoDistancia1(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    

}
