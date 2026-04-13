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
//import codigo.ArenaMediator;

public class Cliente {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Personagem> arena = new ArrayList<>();
        // O Igor 
        // ArenaMediator mediador = new BatalhaMediator();
        
        
        System.out.println("==============================================");
        System.out.println("   BOAS VINDAS AO SIMULADOR DE BATALHAS MEDIEVAIS   ");
        System.out.println("==============================================");
        
        while (true) {
            System.out.println("\n\n\n=== ESCOLHA DE AÇÃO ===");
            System.out.println("Selecione a ação desejada a seguir: ");
            System.out.println("1. Criar Personagem \n2. Equipar Drop de Inimigo \n3. Listar Status\n4. Simular Duelo (Mediator) \n0. Sair\n");
            System.out.print("Escolha: ");
            int opcao = leitor.nextInt();

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Defina o tipo do seu personagem: \n1. Guerreiro \n2. Mago \n3. Assassino \n4. Paladino): ");
                    String escolha = leitor.next();
                    String t = escolha;
                    
                    if (escolha.equals("1")) t = "guerreiro";
                    else if (escolha.equals("2")) t = "mago";
                    else if (escolha.equals("3")) t = "assassino";
                    else if (escolha.equals("4")) t = "paladino";
                    else if (escolha.equalsIgnoreCase("guerreiro") || escolha.equalsIgnoreCase("mago") || 
                            escolha.equalsIgnoreCase("assassino") || escolha.equalsIgnoreCase("paladino")) {
                       t = escolha.toLowerCase();
                    }
	                if (t.equals("")) {
	                    System.out.println("![ERRO] Escolha inválida! Você deve digitar o número (1-4) ou o nome da classe.");
	                    break; 
	                }
	                if (FlyweightFactory.getPersonagem(t) == null) {
	                    System.out.println("![ERRO] O tipo '" + t + "' não existe no sistema. Tente novamente.");
	                } else {
	                    System.out.print("Nome: ");
	                    String n = leitor.next();
	                    arena.add(new PersonagemContexto(n, FlyweightFactory.getPersonagem(t)));
	                    System.out.println("Personagem {" + n + "} criado!");
	                }
	                break;

                case 2:
                    listar(arena);
                    System.out.print("Escolha o personagem: ");
                    int id = leitor.nextInt();
                    System.out.println("Drops disponíveis:\n1. Goblin (Botas)\n2. Golem (Armadura)\n3. Dragão (Espada)\n4. Feiticeiro (Mana)");
                    int item = leitor.nextInt();
                    
                    Personagem p = arena.get(id);
                    if (item == 1) arena.set(id, new BotasAgeis(p));
                    else if (item == 2) arena.set(id, new ArmaduraPedra(p));
                    else if (item == 3) arena.set(id, new EspadaFlamejante(p));
                    else if (item == 4) arena.set(id, new MantoSombrio(p));
                    break;

                case 3:
                    if (arena.isEmpty()) {
                        System.out.println("\n[!] A arena está vazia. Crie seu primeiro personagem!");
                    } else {
                        System.out.println("\n--- STATUS ATUAL DA ARENA ---");
                        listar(arena);
                    }
                    break;

                case 4:
                    System.out.println("\n[Aguardando o Mediator do Igor...]");
                    break;

                default:
                    System.out.println("\n[!] Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void listar(List<Personagem> lista) {
        for (int i = 0; i < lista.size(); i++) {
            Personagem p = lista.get(i);
            System.out.printf("[%d] (%s) %s (HP: %d) \n ATK: %d | DEF: %d | AGI: %d | MANA: %d\n",
                i, p.getNome(), p.getDescricao(), p.getAtaque(), p.getDefesa(), p.getAgilidade(), p.getMana(), p.getVida());
        }
    }
}