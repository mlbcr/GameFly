package codigo;

public interface Personagem {
	int getId();
    String getNome();
    String getDescricao();
    int getAtaque();
    int getDefesa();
    int getAgilidade();
    int getMana();
    int getVida();
    int getManaTotal();
    int getVidaTotal();
    void setVida(int dano, boolean isDano);
    void defender(int defesaE);
    void manipMana(int qtd);
    void diminuiDefesa();

}
