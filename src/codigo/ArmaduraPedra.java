package codigo;

// A Armadura Pedra é um item que garante um bônus de defesa para o personagem
public class ArmaduraPedra extends PersonagemDecorator { 
    public ArmaduraPedra(Personagem p) { 
    	// Chama o construtor da superclasse para manter a referência do objeto decorado
    	super(p); 
    }
    
    @Override
    public int getDefesa() { 
    	// Retorna a defesa do personagem decorado + 10 de armadura
    	return super.getDefesa() + 10;
    }
    
    @Override
    public String getDescricao() {
    	// Junta o nome do item e a descrição do personagem 
    	return super.getDescricao() + " + Armadura de Pedra"; 
    }
    
    // Como a Armadura é apenas uma camada por cima do personagem, ela não sabe gerenciar vida ou mana sozinha.
    // Então ela chama o personagem para ele executar a ação
	public void defender(int defesaE) {
		decorado.defender(defesaE);
	}

	public void manipMana(int qtd) {
		decorado.manipMana(qtd);
	}
	
	public void diminuiDefesa() {
	
		decorado.diminuiDefesa();
	
	}

}

