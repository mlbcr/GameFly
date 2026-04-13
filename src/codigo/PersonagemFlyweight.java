package codigo;

public class PersonagemFlyweight {
    private String tipo, textura, animacao;
    private int ataqueBase, defesaBase, agilidadeBase, manaBase;

    public PersonagemFlyweight(String tipo, String textura, String animacao, int at, int df, int ag, int mn) {
        this.tipo = tipo; this.textura = textura; this.animacao = animacao;
        this.ataqueBase = at; this.defesaBase = df; this.agilidadeBase = ag; this.manaBase = mn;
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
}