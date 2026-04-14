package codigo;
import java.util.*;

// CÓDIGO DO MEDIATOR

public class ArenaMediator {
	
	// Algumas vezes neste código, usarei as nomenclaturas (i, j) e (p1, p2) por uma razão muito simples
		// Existem métodos e ações onde não existe clareza de jogador e inimigo, enquanto existem outros métodos e ações onde existe essa clareza
		// Por isso, quando uso (p1, p2), quer dizer que não existe clareza
		// E quando eu uso (i, j), quer dizer que existe a clareza e ela ajuda
		
		Scanner s = new Scanner(System.in);
		private String[] ordemInimigos = {"goblin", "goblin", "orc", "goblin", "goblin", "gigante", "goblin", "orc", "gigante", "dragao"}; // essa lista é o script de inimigos que será percorrida
		public static int rodada = 0; // para manter o controle sobre o que acontecerá no programa. Quando chegar a 10, o jogo acaba, sendo enviado lá pra classe Cliente
		
		// só pra deixar o programa num fluxo legal
		
		private void pausar(int ms) {
		    try {
		        Thread.sleep(ms);
		    } catch (InterruptedException e) {
		        Thread.currentThread().interrupt();
		    }
		}
		
		
		// Aqui, os inimigos serão chamados de acordo com a posição na lista
		// A fábrica de Flyweight será de grande ajuda, pegando IDs de personagens que estão além do alcance do cliente na classe Cliente
		public int prepararBatalha(Personagem j) {
			
			String tipoInimigo = ordemInimigos[rodada % ordemInimigos.length];
			int resultado = 0; // O resultado vai ser retornado para a classe Cliente para saber quando o jogador ganhou ou perdeu
			
			Personagem i = new PersonagemContexto(tipoInimigo, FlyweightFactory.getPersonagem(tipoInimigo));
			
			// resultado == 0 quer dizer que ainda está na luta
			// resultado == 1 quer dizer que o jogador venceu a luta
			// resultado == -1 quer dizer que o jogador perdeu a luta
			
			while (resultado == 0) resultado = iniciativa(i, j);
			
			if (resultado == 1 && rodada != 10) {
				
				int recuperacao = rodada * 5;
				
				System.out.println("\n\n\n" + j.getNome() + " venceu a rodada " + rodada + "!\nRecuperou " + recuperacao + " de Vida e de Mana.");
				
				pausar(500);
				
				j.setVida(recuperacao, false);
				j.manipMana(-(recuperacao));
				
				pausar(500);
				
				System.out.println("\nProsseguindo para a próxima rodada...");
				
				pausar(700);
				
				// Esse If serve para deixar o jogo mais justo
				
			}
			
			rodada++; // Toda vez que uma luta acaba, o valor estático aumenta
			
			return resultado;
			
		}
		
		
		// Método para definir a ordem das ações
		public int iniciativa(Personagem i, Personagem j) {
			
			System.out.println("\n\n=== RODADA " + (rodada + 1) + " ===\n\n" + j.getNome() + " VS " + i.getNome());
			
			if (j.getAgilidade() > i.getAgilidade()) {
				
				pausar(300);
				
				menu(i, j); // Passa para a vez do jogador
				i.diminuiDefesa(); // Apesar do nome implicar outra coisa, serve para resetar a defesa
				if (i.getVida() <= 0) return 1; // JOGADOR GANHOU
				
				pausar(300);
				
				turnoInimigo(i, j); // Passa para o método de escolha de ação do inimigo
				j.diminuiDefesa(); // Para conseguir aguentar um ataque, pelo menos
				if (j.getVida() <= 0) return -1; // JOGADOR MORREU
				
				pausar(500);
				
			} else {
				
				// O mesmo acima de repete aqui
				
				pausar(300);
				
				turnoInimigo(i, j);
				j.diminuiDefesa();
				if (j.getVida() <= 0) return -1; // JOGADOR MORREU
				
				pausar(300);
				
				menu(i, j);
				i.diminuiDefesa();
				if (i.getVida() <= 0) return 1; // JOGADOR GANHOU
				
				pausar(500);
				
			}
			
			return 0; // A BATALHA AINDA CONTINUA
			
		}
		
		// Menu de ações do jogador, com as 4 opções claras
		public void menu(Personagem i, Personagem j) {
			
			System.out.println("\n\n=== FAÇA A SUA AÇÃO ===\n\nVida: " + j.getVida() + ", Mana:" + j.getMana() + "\n\n 1)Atacar\n 2)Defender\n 3)Habilidade de Classe\n 4)Analisar Inimigo\n\n");
			
			int e = s.nextInt();
			
			switch(e) {
			
			case 1: atacar(j, i, j.getAtaque());
			break;
			
			case 2: defender(j);
			break;
			
			case 3: habilidadeC(j, i);
			break;
			
			case 4: imprimeStatus(i);
			break;
			
			}
			
		}

		// O inimigo escolhe as ações dele aleatoriamente, com uma maior tendência a bater
		public void turnoInimigo(Personagem i, Personagem j) {
			
			pausar(1500);
			
			int n = (int) (Math.random() * 5);
			
			switch(n) {
			
			case 0: atacar(i, j, i.getAtaque());
			break;
			
			case 1: atacar(i, j, i.getAtaque());
			break;
			
			case 2: defender(i);
			break;
			
			case 3: habilidadeC(i, j);
			break;
			
			case 4: habilidadeC(i, j);
			break;
			
			}
			
		}
		
		// Quando ataca, aparece a notificação de que atacaram. O cálculo do dano também é feito no método.
		// O método setVida é chamado para descontar da vida do alvo
		public void atacar(Personagem p1, Personagem p2, int dano) {
			
			pausar(200);
			
			int aleatorio = (int) ((Math.random() * 10) +1); // Dano adicional para variar a quantidade de dano que um ataque causa
			
			int crit = (int) ((Math.random() * 20) +1); // E um sistema de crítico para variar ainda mais
			
			System.out.println(p1.getNome() + " atacou " + p2.getNome());
			
			if (crit >= 19) { // Se o número for maior ou igual a 19, duplica o dano
				
				dano = dano * 2;
				System.out.println("Acerto crítico!");
				
			}
			
			dano = (aleatorio + dano) - p2.getDefesa(); // o cálculo do dano
			
			p2.setVida(dano, true); // true, pois vai causar dano
			
			pausar(1500);
		}
		
		// Com a opção de defesa, você aumenta a própria defesa por 1 turno
		public void defender(Personagem p1) {
			
			pausar(200);
			
			int defesa = p1.getDefesa() * 2;
			p1.defender(defesa); // Para que haja alteração nos atributos, o método defender de Personagem é chamado
			System.out.println(p1.getNome() + " começou a se defender!");
			
			pausar(1500);
			
		}
		
		// As habilidades adicionam variedade tanto para o jogador quanto para o inimigo
		// Elas custam mana, então existem usos limitados para as habilidades
		public void habilidadeC(Personagem p1, Personagem p2) {
			
			pausar(200);
			
			int aleatorio, custo = 10; // Todas as habilidades custam 10 no mínimo. Se você for incapaz de pagar pelo custo, você não usa a habilidade
			
			if (custo > p1.getMana()) System.out.println(p1.getNome() + " não possui mana o suficiente para usar habilidades."); 
			
			else {
			
				// Cada uma das habilidades abaixo usam o que foi definido acima
				switch(p1.getId()) {
				
				case 1:
					
					System.out.println(p1.getNome() + " usou [Corte X]\n");
					atacar(p1, p2, p1.getAtaque() * 3); // um golpe especial que apenas triplica o dano
					p1.manipMana(custo);
					break;
					
				case 2:
					
					System.out.println(p1.getNome() + " usou [Mísseis Mágicos]\n");
					if (p1.getMana() > 80) {
						
						aleatorio = (int) ((Math.random() * 6) + 1);
						for (int i = 0; i < aleatorio; i++) atacar(p1, p2, p1.getAtaque());
						
					} else if (p1.getMana() <= 80 && p1.getMana() > 40) {
						
						aleatorio = (int) ((Math.random() * 4) + 1);
						for (int i = 0; i < aleatorio; i++) atacar(p1, p2, p1.getAtaque());
						
					} else if (p1.getMana() <= 40 && p1.getMana() > 20) {
						
						aleatorio = (int) ((Math.random() * 2) + 1);
						for (int i = 0; i < aleatorio; i++) atacar(p1, p2, p1.getAtaque());
						
					} else { 
						
						aleatorio = p1.getMana() / custo;
						for (int i = 0; i < aleatorio; i++) atacar(p1, p2, p1.getAtaque());
					
					}
					
					System.out.println("\nDisparou " + aleatorio + " míssil(eis).");
					p1.manipMana(custo * aleatorio);
					break;
					
					// Mago é um caso à parte em comparação aos outros por depender de sorte
					// Então preferi manipular o escopo do Math.random() para evitar que a Mana se torne negativa de primeira
					
				case 3:
					
					System.out.println(p1.getNome() + " usou [Ataque das Sombras]\n");
					atacar(p1, p2, p1.getAtaque() * 2); // duplica o dano e ainda aumenta a defesa
					defender(p1);
					p1.manipMana(custo);
					break;
					
				case 4:
					
					System.out.println(p1.getNome() + " usou [Punição Divina]");
					atacar(p1, p2, p1.getAtaque() * 2); // duplica o dano e ainda se cura (falsa)
					p1.setVida(p1.getAtaque(), false);
					p1.manipMana(custo);
					break;
					
				case 5:
					
					// Os inimigos roubam na questão de mana, como em qualquer bom jogo
					
					System.out.println(p1.getNome() + " usou [Facada Tripla]\n");
					int aleatorioG = (int) ((Math.random() * 3) + 1); // ataca até 3 vezes
					for (int i = 0; i < aleatorioG; i++) atacar(p1, p2, p1.getAtaque());
					System.out.println("\nAtacou " + aleatorioG + " vez(es).");
					p1.manipMana(custo * aleatorioG);
					break;
					
				case 6:
					
					System.out.println(p1.getNome() + " usou [Grito de Guerra]\n");
					defender(p1); // começa a se defender e recupera vida perdida
					p1.setVida(p1.getAtaque() - 10, false);
					p1.manipMana(custo * 2);
					break;
					
				case 7:
					
					System.out.println(p1.getNome() + " usou [Esmagar]\n");
					p2.defender(0); // ele ignora a sua defesa nesse ataque
					atacar(p1, p2, p1.getAtaque());
					p1.manipMana(custo * 2);
					break;
					
				case 8:
					
					System.out.println(p1.getNome() + " usou [Baforada Flamejante]\n");
					p2.defender(0); // ele ignora a sua defesa nesse ataque
					atacar(p1, p2, p1.getAtaque() * 2);
					p1.manipMana(custo * 4);
					break;
					
				}
				
				pausar(1500);
			
			}
			
		}
		
		// Imprime os status por meio do toString
		public void imprimeStatus(Personagem p) {
			
			pausar(200);

			System.out.println(p.toString());
			
			pausar(3500);
			
		}

}



