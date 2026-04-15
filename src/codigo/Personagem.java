package codigo;

// A interface Personagem garante que não importa qual tipo do personagem, o sistema vai conseguir acessar  esses métodos básicos
public interface Personagem {
	// Pega o ID para saber qual é a classe base no Flyweight
	int getId();
    String getNome();

    // A descrição que vai aumentando conforme se adicionam itens
    String getDescricao();

    // Status de combate que o Mediator usa para calcular os danos
    int getAtaque();
    int getDefesa();
    int getAgilidade();
    int getMana();
    int getVida();

    // Esses getters definem o limite máximo, para não curar mais do que deve
    int getManaTotal();
    int getVidaTotal();

    // Métodos para os bonecos interagirem durante a treta na arena
    void setVida(int dano, boolean isDano);
    void defender(int defesaE);
    void manipMana(int qtd);
    void diminuiDefesa();
}