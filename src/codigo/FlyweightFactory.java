package codigo;


import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, PersonagemFlyweight> tipos = new HashMap<>();

    public static PersonagemFlyweight getPersonagem(String tipo) {
        if (!tipos.containsKey(tipo.toLowerCase())) {
            switch (tipo.toLowerCase()) {
                case "guerreiro": tipos.put("guerreiro", new PersonagemFlyweight("Guerreiro", "tex_guer.png", "anim_esp", 50, 40, 20, 10)); break;
                case "mago":      tipos.put("mago",      new PersonagemFlyweight("Mago", "tex_mag.png", "anim_caj", 30, 10, 30, 100)); break;
                case "amazona":   tipos.put("amazona",   new PersonagemFlyweight("Amazona", "tex_ama.png", "anim_lan", 45, 25, 60, 20)); break;
            }
        }
        return tipos.get(tipo.toLowerCase());
    }
}