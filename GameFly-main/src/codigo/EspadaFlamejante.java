package codigo;

public class EspadaFlamejante extends PersonagemDecorator { 
    public EspadaFlamejante(Personagem p) {
    	super(p); 
    }
    
    @Override
    public int getAtaque() {
    	return super.getAtaque() + 10; 
    }
    
    @Override
    public String getDescricao() {
    	return super.getDescricao() + " + Espada Flamejante"; 
    }

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