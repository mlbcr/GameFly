package codigo;

public abstract class PersonagemDecorator implements Personagem {
    protected Personagem decorado;
    
    public PersonagemDecorator(Personagem p) { 
        this.decorado = p; 
    }
    
    public int getId() {
    	return decorado.getId();
    }
    
    public String getNome() { 
    	return decorado.getNome();
    }
    public int getVida() {
    	return decorado.getVida(); 
    }
    public void setVida(int dano, boolean isDano) {
    	
    	
    	decorado.setVida(dano, isDano); 
    }

    public int getAtaque() {
    	return decorado.getAtaque(); 
    }
    public int getDefesa() {
    	return decorado.getDefesa(); 
    }
    public int getAgilidade() {
    	return decorado.getAgilidade(); 
    }
    public String getDescricao() {
    	return decorado.getDescricao(); 
    }
    public int getMana() {
		return decorado.getMana();
	}
    public int getVidaTotal() {
    	return decorado.getVidaTotal();
    }
    public int getManaTotal() {
    	return decorado.getManaTotal();
    }
    
    public String toString() {
    	return "Personagem [Vida= " + getVida() + "/" + getVidaTotal() + ", Mana= " + getMana() + "/" + getManaTotal() + ", Nome= " + getNome() + "]\n\n[Força= " + getAtaque() + "\nDefesa= " + getDefesa() + "\nAgilidade= " + getAgilidade() + "]";
    }

}







