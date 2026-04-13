package codigo;

// Adicionado 'public' para ser visível fora do pacote
public abstract class PersonagemDecorator implements Personagem {
    protected Personagem decorado;
    
    public PersonagemDecorator(Personagem p) { 
        this.decorado = p; 
    }
    
    public String getNome() { return decorado.getNome(); }
    public int getVida() { return decorado.getVida(); }
    public void setVida(int vida) { decorado.setVida(vida); }
    public int getAtaque() { return decorado.getAtaque(); }
    public int getDefesa() { return decorado.getDefesa(); }
    public int getAgilidade() { return decorado.getAgilidade(); }
    public int getMana() { return decorado.getMana(); }
    public String getDescricao() { return decorado.getDescricao(); }
}







