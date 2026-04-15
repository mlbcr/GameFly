package codigo;

// CONTEXTO DO FLYWEIGHT

public class PersonagemContexto implements Personagem {
	// Esses são os atributos que fazem parte do estado extrínseco
    private String nome;
    private int vida, vidaTotal, mana, manaTotal, ataque, defesa, agilidade;
    
    // Essa é a referência ao objeto compartilhado do estado intrínseco (o flyweight)
    private PersonagemFlyweight flyweight;
    
    private boolean usouDefesa = false;
    
    public PersonagemContexto(String nome, PersonagemFlyweight flyweight) {
        this.nome = nome;
        // Inicia os atributos individuais com base nos valores fixos do Flyweight
        this.ataque = flyweight.getAtaque();
        this.agilidade = flyweight.getAgilidade();
        this.flyweight = flyweight;
        this.vida = flyweight.getVida();
        this.vidaTotal = flyweight.getVidaTotal();
        this.mana = flyweight.getMana();
        this.manaTotal = flyweight.getManaTotal();
        this.defesa = flyweight.getDefesa();
    }
    
	public int getId() {
		return flyweight.getId();
	}

    public String getNome() { 
    	return this.nome; 
    }
   
    public String getDescricao() {
    	// Busca o tipo do personagem diretamente do objeto compartilhado
    	return flyweight.getTipo(); 
    }
    // Esses getters retornam os atributos atuais do personagem
    // Eles permitem que o Mediator e o Decorator consultem os valores dos atributos
    public int getAtaque() {
    	return this.ataque; 
    }
    public int getDefesa() {
    	return this.defesa; 
    }
    public int getAgilidade() {
    	return this.agilidade; 
    }
    public int getVida() {
    	return this.vida; 
    }
    public int getMana() {
    	return this.mana;
    }
    public int getVidaTotal() {
    	return this.vidaTotal;
    }
    public int getManaTotal() {
    	return this.manaTotal;
    }
    
    
    // setVida vai servir para causar dano ao personagem, mas também para curar o personagem
    // Como parâmetros, recebe o valor do dano/cura e um boolean
    // O boolean serve para saber se deve causar dano (true) ou se deve curar (false)
    public void setVida(int dano, boolean isDano) {
    	
    	if (isDano) {
    	
    		if (dano > 0) {
    		// Quer dizer que causou dano, no mínimo de 1
    			this.vida -= dano;
    		
    			System.out.println(this.nome + " recebeu " + dano + " de dano.");
    		
    		} else System.out.println(this.nome + " recebeu 0 de dano."); // Quer dizer que a defesa foi boa o suficiente para anular o dano
    	
    		if (this.vida > 0) System.out.println("Vida atual de " + this.nome + ": " + this.vida); // Diz a vida atual
    	
    		else vida = 0; // Se a vida zerou, o inimigo morreu
    		
    	} else {
    		
    		this.vida += dano;
    		
    		System.out.println(this.nome + " recebeu " + dano + " de cura."); // Quer dizer que curou alguma coisa
    		
    		if (this.vida > this.vidaTotal) vida = vidaTotal; // Mesma lógica do código acima
    		
    		System.out.println("Vida atual de " + this.nome + ": " + this.vida);
    		
    	}
    	
    }

    // Aqui, a defesa aumenta pelo valor passado pelo Mediador e usouDefesa se torna true
    @Override
	public void defender(int defesaE) {

		defesa = defesaE;
		usouDefesa = true;
		
	}
	
    // Apesar do nome implicar outra coisa, serve para resetar a defesa
	public void diminuiDefesa() {
		
		defesa = flyweight.getDefesa();
		usouDefesa = false;
		
	}
	
	// Serve para reduzir ou aumentar a mana do Personagem, dependendo de suas ações
	// Não pode extrapolar os limites, assim como a vida
	// Também pode-se passar qtd negativo para adicionar mana
	public void manipMana(int qtd) {
		
		this.mana -= qtd;
		
		if (this.mana < 0) this.mana = 0;
		
		if (this.mana > this.manaTotal) this.mana = this.manaTotal;
		
	}
	
	// Método toString para apresentar todas as informações mais importantes do Personagem
	public String toString() {
		return "Personagem [Vida= " + getVida() + "/" + getVidaTotal() + ", Mana= " + getMana() + "/" + getManaTotal() + ", Nome= " + getNome() + "]\n\n[Força= " + getAtaque() + "\nDefesa= " + getDefesa() + "\nAgilidade= " + getAgilidade() + "]";
	}


}