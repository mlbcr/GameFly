package codigo;

public class MantoSombrio extends PersonagemDecorator { 
    public MantoSombrio(Personagem p) {
    	super(p); 
    }
    
    @Override
    public int getMana() {
    	return decorado.getMana() + 20; 
    }
    
    @Override
    public String getDescricao() { 
    	return decorado.getDescricao() + " + Manto Sombrio"; 
    	}
}
