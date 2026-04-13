package codigo;

public class PersonagemContexto implements Personagem {
    private String nome;
    private int vida;
    private PersonagemFlyweight flyweight;

    public PersonagemContexto(String nome, PersonagemFlyweight flyweight) {
        this.nome = nome;
        this.flyweight = flyweight;
        this.vida = 100;
    }

    public String getNome() { 
    	return nome; 
    }
   
    public String getDescricao() {
    	return flyweight.getTipo(); 
    }
    public int getAtaque() {
    	return flyweight.getAtaque(); 
    }
    public int getDefesa() {
    	return flyweight.getDefesa(); 
    }
    public int getAgilidade() {
    	return flyweight.getAgilidade(); 
    }
    public int getMana() {
    	return flyweight.getMana(); 
    }
    public int getVida() {
    	return vida; 
    }
    
    public void setVida(int vida) {
    	this.vida = vida; 
    }
}