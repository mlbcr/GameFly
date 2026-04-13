package codigo;

public class EspadaFlamejante extends PersonagemDecorator { 
    public EspadaFlamejante(Personagem p) {
    	super(p); 
    }
    
    @Override
    public int getAtaque() {
    	return decorado.getAtaque() + 10; 
    }
    
    @Override
    public String getDescricao() {
    	return decorado.getDescricao() + " + Espada Flamejante"; 
    }
}