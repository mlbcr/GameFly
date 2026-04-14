package codigo;
import java.util.Random;

public class BotasAgeis extends PersonagemDecorator { 
    public BotasAgeis(Personagem p) { super(p); }
    
    @Override
    public int getAgilidade() {
    	return super.getAgilidade() + 5; 
    }
    
    @Override
    public String getDescricao() {
    	return super.getDescricao() + " + Botas Ágeis"; 
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
