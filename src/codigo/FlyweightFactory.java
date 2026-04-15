package codigo;

import java.util.HashMap;
import java.util.Map;

// Esta  classe serve para garantir que não sejam criados objetos repetidos desnecessariamente
// Então, se um personagem já foi criado uma vez, só entrega a versão que está guardada
public class FlyweightFactory {
    // Mapa que guarda as instâncias únicas de cada classe
    private static Map<String, PersonagemFlyweight> tipos = new HashMap<>();

    public static PersonagemFlyweight getPersonagem(String tipo) {
        String tipoChave = tipo.toLowerCase();

        // Se o tipo ainda não estiver no mapa, é criado
        if (!tipos.containsKey(tipoChave)) {
            
            // Aqui são definidos os dados pesados e fixos de cada classe apenas uma vez
            switch (tipoChave) {
                case "guerreiro":
                    tipos.put(tipoChave, new PersonagemFlyweight(1, 120, "Guerreiro", "tex_guer.png", "anim_espada", 50, 30, 20, 30));
                    break;
                case "mago":
                    tipos.put(tipoChave, new PersonagemFlyweight(2, 80, "Mago", "tex_mago.png", "anim_cajado", 35, 10, 25, 150));
                    break;
                case "assassino":
                    tipos.put(tipoChave, new PersonagemFlyweight(3, 85, "Assassino", "tex_assas.png", "anim_adaga", 60, 20, 80, 30));
                    break;
                case "paladino":
                    tipos.put(tipoChave, new PersonagemFlyweight(4, 100, "Paladino", "tex_pala.png", "anim_martelo", 40, 35, 15, 50));
                    break;
                case "goblin":
                    tipos.put(tipoChave, new PersonagemFlyweight(5, 50, "Goblin", "tex_goblin.png", "anim_faca", 32, 20, 60, 60));
                    break;
                case "orc":
                    tipos.put(tipoChave, new PersonagemFlyweight(6, 110, "Orc", "tex_orc.png", "anim_clava", 40, 30, 18, 50));
                    break;
                case "gigante":
                    tipos.put(tipoChave, new PersonagemFlyweight(7, 250, "Gigante", "tex_gigante.png", "anim_mao_gigante", 55, 30, 5, 50));
                    break;
                case "dragao":
                    tipos.put(tipoChave, new PersonagemFlyweight(8, 500, "Dragão", "tex_dragao.png", "anim_voo", 35, 50, 200, 120));
                    break;
                default:
                    return null;
            }
        }
        
        // Retorna o personagem que já estava guardado ou o que acabou de ser criado
        return tipos.get(tipoChave);
    }
}