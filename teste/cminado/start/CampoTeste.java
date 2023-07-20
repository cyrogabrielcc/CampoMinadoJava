package cminado.start;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import cminado.exceptions.ExplosaoException;

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

    @Test
    public void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }

    @Test
    public void testAlternarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    public void testAlternarMarcacaoDuasChamadas(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    public void testAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());
    }

    @Test
    public void testAbrirMinadoMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    public void testAbrirMinadoNaoMarcado(){
        campo.minar();
        assertThrows(ExplosaoException.class, () ->{
            campo.abrir();
        } );
    }

    @Test
    public void testAbrirComVizinhos(){
        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,1);
        campo12.minar();
        Campo campo22 = new Campo(2,2);

        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo22.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
}
