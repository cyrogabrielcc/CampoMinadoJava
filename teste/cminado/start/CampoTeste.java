package cminado.start;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CampoTeste {
    
    private Campo campo = new Campo(3,3);

    @BeforeEach
    public void iniciarCampo(){
        campo = new Campo(3, 3);
        
    }

    @Test
    public void testeVizinhoDistanciaDireita(){
        Campo vizinho = new Campo(3,4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistanciaEsquerda(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    @Test
    public void testeVizinhoDistanciaCima(){
        Campo vizinho = new Campo(2,3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    @Test
    public void testeVizinhoDistanciaBaixo(){
        Campo vizinho = new Campo(4,3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistanciaDiagonal(){
        Campo vizinho = new Campo(2,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    public void testeNaoVizinhoDistancia(){
        Campo vizinho = new Campo(1,1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }
}
