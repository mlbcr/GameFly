package codigo;

public class MantoSombrio extends PersonagemDecorator { 
    public MantoSombrio(Personagem p) {
    	super(p); 
    }
    
    @Override
    public String getDescricao() { 
    	return super.getDescricao() + " + Manto Sombrio"; 
    }

	public void defender(int defesaE) {
		
		decorado.defender(defesaE);
		
	}
	
	public int getMana	() {
		
		return super.getMana() + 20; 
	}
	
	public int getManaTotal() {
		
		return super.getManaTotal() + 20; 
	}
	
	public void manipMana(int qtd) {
		
		decorado.manipMana(qtd);
		
	}
	
	public void diminuiDefesa() {
		
		decorado.diminuiDefesa();
		
	}
}
