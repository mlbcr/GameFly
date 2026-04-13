package codigo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, PersonagemFlyweight> tipos = new HashMap<>();

    public static PersonagemFlyweight getPersonagem(String tipo) {
        String tipoChave = tipo.toLowerCase();

        if (!tipos.containsKey(tipoChave)) {
            
            switch (tipoChave) {
                case "guerreiro":
                    tipos.put(tipoChave, new PersonagemFlyweight("Guerreiro", "tex_guer.png", "anim_espada", 50, 40, 20, 10));
                    break;
                case "mago":
                    tipos.put(tipoChave, new PersonagemFlyweight("Mago", "tex_mago.png", "anim_cajado", 30, 10, 25, 100));
                    break;
                case "assassino":
                    tipos.put(tipoChave, new PersonagemFlyweight("Assassino", "tex_assas.png", "anim_adaga", 60, 15, 80, 30));
                    break;
                case "paladino":
                    tipos.put(tipoChave, new PersonagemFlyweight("Paladino", "tex_pala.png", "anim_martelo", 40, 60, 15, 50));
                    break;
                default:
                    return null;
            }
        }
        return tipos.get(tipoChave);
    }
}