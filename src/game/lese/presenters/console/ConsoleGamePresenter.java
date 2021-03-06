/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.presenters.console;

import game.lese.main.DynamicAnnotation;
import game.lese.model.Player;
import game.lese.model.dao.PlayerDAO;
import game.lese.presenters.interfaces.GamePresenter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class ConsoleGamePresenter implements GamePresenter {

    @Override
    public int showMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1 - Jogar");
        System.out.println("2 - Acessar Ranking");
        System.out.println("3 - Ajuda");
        
        
        if(DynamicAnnotation.PROJECT_MANAGMENT) {
            System.out.println("4 - Autenticar");
            System.out.println("5 - Exit\n");
        } else {
            System.out.println("4 - Exit\n");            
        }
        
        System.out.print("Escolha a opção: ");
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    @Override
    public void showRanking() {
        List<Player> players = new PlayerDAO().ranking();
        System.out.println("--------------------Ranking----------------------\n");
        if (!players.isEmpty()) {
            int position = 1;
            for (Player p : players) {
                System.out.println(position + " - " + p.getName() + " -------------------- " + p.getScore());
                position++;
            }
        } else {
            System.out.println("Ranking vazio.");
        }
    }

    @Override
    public void showHelp() {
        System.out.println("O objetivo do jogo LeSE é ensinar o processo de desenvolvimento iterativo e incremental, através da\n"
                + "aplicação de conceitos existentes na engenharia de software, por meio de perguntas e de situações que acontecem durante o jogo.\n"
                + "A principal finalidade do jogo é criar uma estratégia complementar de ensino, onde os alunos deverão colocar\n"
                + "em prática o conhecimento adquirido em sala de aula.\n\n"
                + "Para iniciar o jogo, selecione a opção Jogar disponibilizada no menu inicial. Feito isso, o sistema solicitará que você\n"
                + "informe o seu nome ou apelido. Ao iniciar o jogo, é exibida uma mensagem de boas vindas, seguida da descrição do projeto\n"
                + "que ele irá participar. Durante o jogo, o jogador deve responder uma pergunta sorteada pelo jogo, sempre relacionada ao\n"
                + "estágio em que o projeto se encontra no tabuleiro. As perguntas exibidas pertencem a um dos dois estilos: “múltipla escolha”\n"
                + "ou “verdadeiro ou falso”. Se o aluno responder a pergunta corretamente ele ganha pontos e avança casas; caso responda de forma\n"
                + "incorreta, perde pontos e retorna casas. O valor da pontuação é dada de acordo com o grau de dificuldade da questão.");
    }

    @Override
    public void showExit() {
        System.out.println("Obrigado por ter participado do jogo! Esperamos que tenha gostado.\nAté breve!");
    }

    @Override
    public void showDefault() {
        System.out.println("Opção inexistente! Escolha novamente.");
    }

    @Override
    public void showWelcomeMsg() {
        System.out.println("Seja Bem Vindo ao LeSE!");
    }

    @Override
    public void cleanConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.println("\f");
            }
        } catch (final Exception e) {
            System.out.println("Algo deu errado :(");
        }
    }
    
    @Override
    public boolean continueGame() {
        String option = "";
        do{
            System.out.print("Digite s ou enter para continuar ou n para finalizar o jogo: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine();
            if(option.length() > 0 && !option.equals("s") && !option.equals("n")){
                System.out.println("Opção inválida! Tente novamente.");
            }
        }while(option.length() > 0 && !option.equals("s") && !option.equals("n"));
        return (option.equals("s") || option.length() == 0 );
    }

}
