package codigo;
import java.util.Random;

// Botas Ágeis é um item que garante um bônus de agilidade para o personagem
public class BotasAgeis extends PersonagemDecorator { 
    public BotasAgeis(Personagem p) { 
    	// Chama o construtor da superclasse para manter a referência do objeto decorado
    	super(p); 
    }
    
    @Override
    public int getAgilidade() {
    	// Retorna a agilidade do personagem decorado + 5 de agilidade
    	return super.getAgilidade() + 5; 
    }
    
    @Override
    public String getDescricao() {
    	// Junta o nome do item e a descrição do personagem 
    	return super.getDescricao() + " + Botas Ágeis"; 
    }

    // Como as Botas são apenas uma camada por cima do personagem, elas não sabem gerenciar vida ou mana sozinhas.
    // Então elas chamam o personagem para ele executar a ação
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