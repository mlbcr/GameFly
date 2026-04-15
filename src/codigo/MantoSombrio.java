package codigo;

// Manto Sombrio é um item que garante um bônus de mana para o personagem
public class MantoSombrio extends PersonagemDecorator { 
    public MantoSombrio(Personagem p) {
    	// Chama o construtor da superclasse para manter a referência do objeto decorado
    	super(p); 
    }
    
    @Override
    public String getDescricao() { 
    	// Junta o nome do item e a descrição do personagem 
    	return super.getDescricao() + " + Manto Sombrio"; 
    }

    // Como o Manto é apenas uma camada por cima do personagem, ele não sabe gerenciar vida ou mana sozinho.
    // Então ele chama o personagem para ele executar a ação
	public void defender(int defesaE) {
		decorado.defender(defesaE);
	}
	
	public int getMana() {
		// Retorna a mana do personagem decorado + 20 de bônus
		return super.getMana() + 20; 
	}
	
	public int getManaTotal() {
		// Retorna a mana total do personagem decorado + 20 de bônus
		return super.getManaTotal() + 20; 
	}
	
	public void manipMana(int qtd) {
		decorado.manipMana(qtd);
	}
	
	public void diminuiDefesa() {
		decorado.diminuiDefesa();
	}
}