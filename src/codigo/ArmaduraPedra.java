package codigo;

public class ArmaduraPedra extends PersonagemDecorator { 
    public ArmaduraPedra(Personagem p) { super(p); }
    
    @Override
    public int getDefesa() { return decorado.getDefesa() + 10; }
    
    @Override
    public String getDescricao() { return decorado.getDescricao() + " + Armadura de Pedra"; }
}
