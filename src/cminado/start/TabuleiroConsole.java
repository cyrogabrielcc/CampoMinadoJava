package cminado.start;

import java.util.Scanner;

import cminado.exceptions.ExplosaoException;
import cminado.exceptions.SairException;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    
    Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;

        executarJogo();
    }
    
    
    
    private void executarJogo(){
        try {
            boolean continuar = true;
            while (continuar) {
                System.out.println("Outra partida? (S/n)");
                cicloDoJogo();
                String resposta = entrada.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                }
                else{
                    tabuleiro.reiniciar();
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Byeeeeee!");
        } 
        finally {
            entrada.close();
        }
    }
    private void cicloDoJogo() {
        try {
            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);
                String digitado = capturarValorDigitado(" ");
            }
            System.out.println("GANHOOOOOOOOU!!!");
        } catch (ExplosaoException e) {
            System.out.println("PERDEU!");
        }
    }

    private String capturarValorDigitado(String texto){
        System.out.print(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        } 
        
        return digitado;
        
    }
}
