package school.faang.BJS2_57340;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> spelNames = new HashMap<>();
        spelNames.put("Alohomora", "The door is unlocked by ");
        spelNames.put("Lumos", "A beam of light is created by ");
        spelNames.put("Expelliarmus", "The opponent is disarmed by ");
        SpellCaster spellCaster = new SpellCaster();
        for (Map.Entry<String, String> entry : spelNames.entrySet()) {
            spellCaster.cast(entry.getKey(), (spell) -> entry.getValue() + spell);
        }
    }
}
