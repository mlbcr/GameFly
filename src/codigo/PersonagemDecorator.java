package codigo;

// Esta classe serve como a base para todos os itens do jogo.
// Ela envolve um personagem para adicionar bônus a ele e implementa a interface Personagem para que o personagem com item seja 
//tratado como um personagem comum.
public abstract class PersonagemDecorator implements Personagem {
    
    // Referencia o personagem que será decorado
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
        // O dano ou cura é aplicado diretamente no personagem
    	decorado.setVida(dano, isDano); 
    }

    // Estes métodos de atributos serão sobrescritos pelas classes filhas para adicionar os bônus específicos de cada equipamento
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
    
    // Retorna uma representação em texto do personagem já com os bônus aplicados.
    public String toString() {
    	return "Personagem [Vida= " + getVida() + "/" + getVidaTotal() + ", Mana= " + getMana() + "/" + getManaTotal() + ", Nome= " + getNome() + "]\n\n[Força= " + getAtaque() + "\nDefesa= " + getDefesa() + "\nAgilidade= " + getAgilidade() + "]";
    }
}