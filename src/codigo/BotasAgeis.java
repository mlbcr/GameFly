package codigo;

public class BotasAgeis extends PersonagemDecorator { 
    public BotasAgeis(Personagem p) { super(p); }
    
    @Override
    public int getAgilidade() { return decorado.getAgilidade() + 5; }
    
    @Override
    public String getDescricao() { return decorado.getDescricao() + " + Botas Ágeis"; }
}
