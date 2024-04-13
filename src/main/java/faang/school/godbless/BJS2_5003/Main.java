package faang.school.godbless.BJS2_5003;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        List<String> spells = Arrays.asList("Alohomora", "Expelliarmus", "Expecto Patronum");

        Map<String, SpellAction> spellAndAction = new HashMap<>();

        spellAndAction.put(spells.get(0), spell -> "Unlocking Charm this is " + spell);
        spellAndAction.put(spells.get(1), spell -> "Disarm this is " + spell);
        spellAndAction.put(spells.get(2), spell -> "Patronus Charm this is  " + spell);

        for(Map.Entry<String, SpellAction> entry : spellAndAction.entrySet()) {
            spellCaster.cast(entry.getKey(), entry.getValue());
        }
    }
}
