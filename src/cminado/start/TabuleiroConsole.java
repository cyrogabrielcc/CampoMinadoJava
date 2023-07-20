package cminado.start;

import java.util.Scanner;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    
    Scanner s = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;

        executarJogo();
    }
    
    
    
    private void executarJogo(){
        try {
            boolean continuar = true;
            while (continuar) {
                System.out.println("Outra partida? (S/n)");
                String resposta = s.nextLine();

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

        }
    }
}
