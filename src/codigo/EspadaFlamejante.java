package codigo;

// A Espada Flamenjante é um item que garante um bônus de ataque para o personagem
public class EspadaFlamejante extends PersonagemDecorator { 
    public EspadaFlamejante(Personagem p) {
    	// Chama o construtor da superclasse para manter a referência do objeto decorado
    	super(p); 
    }
    
    @Override
    public int getAtaque() {
    	// Retorna o ataque do personagem decorado + 10 de ataque
    	return super.getAtaque() + 10; 
    }
    
    @Override
    public String getDescricao() {
    	// Junta o nome do item e a descrição do personagem 
    	return super.getDescricao() + " + Espada Flamejante"; 
    }

    // Como a Espada é apenas uma camada por cima do personagem, ela não sabe gerenciar vida ou mana sozinha.
    // Então ela chama o personagem para ele executar a ação
	@Override
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