package cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import codigo.Personagem;
import codigo.PersonagemContexto;
import codigo.FlyweightFactory;
import codigo.PersonagemDecorator;
import codigo.BotasAgeis;
import codigo.ArmaduraPedra;
import codigo.EspadaFlamejante;
import codigo.MantoSombrio;
import codigo.ArenaMediator;

public class Cliente {
	
	// só pra deixar o programa num fluxo legal
	
	private static void pausar(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}
	
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Personagem> arena = new ArrayList<>(); //
        ArenaMediator mediador = new ArenaMediator(); // Iniciando a classe ArenaMediator aqui
        
        System.out.println("==============================================");
        System.out.println(" BOAS VINDAS AO SIMULADOR DE BATALHAS MEDIEVAIS ");
        System.out.println("==============================================");
        
        // Menu que só acaba quando digitar 0
        
        while (true) {
            System.out.println("\n\n=== ESCOLHA DE AÇÃO ===");
            System.out.println("Selecione a ação desejada a seguir: ");
            System.out.println("1. Criar Personagem \n2. Equipar Drop de Inimigo \n3. Listar Tropas\n4. Simular Duelo \n0. Sair\n");
            System.out.print("Escolha: ");
            int opcao = leitor.nextInt();

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                	
                	pausar(300);
                	
                	criacaoPersonagem(arena);
                	
                	pausar(300);
                	
	                break;

                case 2:
                	
                	pausar(300);
                    
                	arenaEquipar(arena);
                	
                	pausar(300);
                	
                    break;

                case 3:
                	
                	pausar(200);
                	
                    if (arena.isEmpty()) {
                        System.out.println("\n[!] A arena está vazia. Crie seu primeiro personagem!");
                    } else {
                        System.out.println("\n--- STATUS ATUAL DA ARENA ---");
                        listar(arena);
                    }
                    
                    pausar(400);
                    
                    break;

                case 4:
                	
                	pausar(200);
                	
                	// Antes de começar o jogo, você escolhe um dos personagens que você criou
                	
                	System.out.println("Lista de personagens disponíveis: ");
                	listar(arena);
                    System.out.print("Escolha o personagem pelo índice: ");
                    int idLuta = leitor.nextInt();
                    
                    // Para você escolher a opção disponível
                    if (idLuta < 0 || idLuta >= arena.size()) {
                        System.out.println("[!] Índice ultrapassou a quantidade de personagens da arena.");
                        break;
                    }
                    
                    // O personagem selecionado é carregado
                    Personagem pLuta = arena.get(idLuta);
                    int resultado = 0;
                    
                    // Se o resultado for -1, quer dizer que o jogador perdeu, levando pro game over
                    while (resultado != -1) {
                	
                    	// Você começa as lutas a partir dessa chamada
                    	resultado = mediador.prepararBatalha(pLuta);
                    	
                    	if (resultado == 1) {
                    		// resultado = 1 quer dizer que você ganhou
                    		if (mediador.rodada >= 10) {
                        		// se chegar a 10 rodadas, você zerou o jogo
                        		System.out.println("\n\nMeus parabéns! Você conseguiu derrotar o dragão e zerou o jogo!");
                        		mediador.rodada = 0;
                        		break;
                        		
                        	}
                    		
                    	}
                    	
                    	if (resultado == -1) { 
                    		
                    		System.out.println("\n\n===== GAME OVER ====="); 
                    		mediador.rodada = 0;
                    	
                    	}
                    	
                    	pausar(5000);
                	
                    }
                    
            }
        }
    }
    
    private static void criacaoPersonagem(List<Personagem> arena) {
    	
    	Scanner leitor = new Scanner(System.in);
    	String t = "";
        System.out.print("Defina o tipo do seu personagem: \n1. Guerreiro \n2. Mago \n3. Assassino \n4. Paladino\n Escolha: ");
        String escolha = leitor.next();
        t = escolha;
        
        if (escolha.equals("1") || escolha.equalsIgnoreCase("guerreiro")) t = "guerreiro";
        else if (escolha.equals("2") || escolha.equalsIgnoreCase("mago")) t = "mago";
        else if (escolha.equals("3") || escolha.equalsIgnoreCase("assassino")) t = "assassino";
        else if (escolha.equals("4") || escolha.equalsIgnoreCase("paladino")) t = "paladino";

        if (t.equals("")) {
            System.out.println("[!] Escolha inválida! Você deve digitar o número (1-4) ou o nome da classe.");
            return;
        }
        if (FlyweightFactory.getPersonagem(t) == null) {
            System.out.println("[!] O tipo '" + t + "' não existe no sistema. Tente novamente.");
        } else {
            System.out.print("Nome: ");
            String n = leitor.next();
            arena.add(new PersonagemContexto(n, FlyweightFactory.getPersonagem(t)));
            System.out.println("Personagem {" + n + "} criado!");
        }
    	
    }
    
    private static void arenaEquipar(List<Personagem> arena) {
        Scanner leitor = new Scanner(System.in);
        int item = 1, id = -1; 

        if (arena.isEmpty()) { 
            System.out.println("[!] Arena vazia! Crie um personagem primeiro."); 
            return; 
        }

        while (true) {
            listar(arena);
            System.out.print("\nEscolha o personagem pelo índice (ou digite -1 para voltar ao menu): ");
            id = leitor.nextInt();

            if (id == -1) break; 

            if (id < 0 || id >= arena.size()) {
                System.out.println("[!] Índice inválido. Tente novamente.");
                continue; 
            }
            
            pausar(500);

            while (true) {
                System.out.println("Drops disponíveis:\n1. Botas (+5 AGI)\n2. Armadura (+10 DEF)\n3. Espada (+10 ATK)\n4. Manto (+20 MANA)\n0. Visualizar outro personagem.");
                System.out.print("Escolha o item: ");
                item = leitor.nextInt();

                if (item == 0) break; 

                Personagem p = arena.get(id); 
                String descricaoAtual = p.getDescricao();
                boolean jaEquipado = false;
                String nomeItem = "";

                if (item == 1) {
                    nomeItem = "Botas Ágeis";
                    if (descricaoAtual.contains(nomeItem)) jaEquipado = true;
                    else { 
                    	p = new BotasAgeis(p);
                    	arena.set(id, p); 
                    }
                    
                } 
                else if (item == 2) {
                    nomeItem = "Armadura de Pedra";
                    if (descricaoAtual.contains(nomeItem)) jaEquipado = true;
                    else { 
                    	p = new ArmaduraPedra(p);
                    	arena.set(id, p); 
                    }
                } 
                else if (item == 3) {
                    nomeItem = "Espada Flamejante";
                    if (descricaoAtual.contains(nomeItem)) jaEquipado = true;
                    else { 
                    	p = new EspadaFlamejante(p);
                    	arena.set(id, p); 
                    }
                } 
                else if (item == 4) {
                    nomeItem = "Manto Sombrio";
                    if (descricaoAtual.contains(nomeItem)) jaEquipado = true;
                    else { 
                    	p = new MantoSombrio(p);
                    	arena.set(id, p); 
                    }
                }

                if (jaEquipado) {
                    System.out.println("[AVISO] " + p.getNome() + " já possui: " + nomeItem);
                } else if (!nomeItem.equals("")) {
                    System.out.println(p.getNome() + " equipou " + nomeItem + " com sucesso!");
                }
                
                pausar(900);
            }
            
            pausar(500);
        }
        
        pausar(1000);
    }

    private static void listar(List<Personagem> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("[" + i + "] - " + lista.get(i).toString() + "\n");
            pausar(500);
        }
    }
}