package codigo;

// Esta classe representa o Estado Intrínseco do padrão Flyweight.
public class PersonagemFlyweight {
    // Dados que não mudam entre instâncias do mesmo tipo 
    private String tipo, textura, animacao;
    
    // Atributos base
    private int id, vida, vidaTotal, ataqueBase, defesaBase, agilidadeBase, manaBase, manaTotal;

    public PersonagemFlyweight(int id, int vida, String tipo, String textura, String animacao, int at, int df, int ag, int mn) {
        this.id = id; 
        this.vida = vida; 
        this.tipo = tipo; 
        this.textura = textura; 
        this.animacao = animacao;
        this.ataqueBase = at; 
        this.defesaBase = df; 
        this.agilidadeBase = ag; 
        this.manaBase = mn;
        this.vidaTotal = vida; 
        this.manaTotal = mn;
    }
    

    // Esses métodos getters permitem que o PersonagemContexto acesse os valores compartilhados 
    // para inicializar seus próprios atributos

    public int getId() {
    	return id;
    }
    
    public int getVida() {
    	return vida;
    }
    
    public int getVidaTotal() {
    	return vidaTotal;
    }

    public String getTipo() { 
    	return tipo; 
    }
    
    public int getAtaque() {
    	return ataqueBase; 
    }
    
    public int getDefesa() {
    	return defesaBase; 
    }
    
    public int getAgilidade() {
    	return agilidadeBase; 
    }
    
    public int getMana() {
    	return manaBase;
    }
    
    public int getManaTotal() {
    	return manaTotal;
    }
    
}