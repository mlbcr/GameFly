package codigo;

public class ArmaduraPedra extends PersonagemDecorator { 
    public ArmaduraPedra(Personagem p) { 
    	super(p); 
    }
    
    @Override
    public int getDefesa() { 
    	return super.getDefesa() + 10;
    }
    
    @Override
    public String getDescricao() {
    	return super.getDescricao() + " + Armadura de Pedra"; 
    	}

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

