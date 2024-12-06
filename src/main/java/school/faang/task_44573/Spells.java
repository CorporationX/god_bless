package school.faang.task_44573;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Spells {

    private static final Map<String, String> SPELLS;

    private static Random random = new Random();

    static {
        Map<String, String> spells = new HashMap<>();
        spells.put("Fireball", "Launches a fiery ball that explodes on impact, dealing damage to enemies within a radius.");
        spells.put("Frost Nova", "Creates a burst of freezing energy, slowing or immobilizing nearby enemies.");
        spells.put("Lightning Bolt", "Fires a bolt of lightning that strikes a single target with immense force.");
        spells.put("Healing Touch", "Restores health to an ally or the caster over a short period of time.");
        spells.put("Arcane Shield", "Surrounds the caster with a protective shield that absorbs a certain amount of damage.");
        spells.put("Summon Familiar", "Calls forth a magical creature to assist the caster in battle or exploration.");
        spells.put("Invisibility", "Makes the caster invisible for a limited time, allowing them to avoid detection.");
        spells.put("Teleport", "Instantly transports the caster to a chosen location within a certain range.");
        spells.put("Dispel Magic", "Removes magical effects or curses from a target.");
        SPELLS = Collections.unmodifiableMap(spells);
    }

    public static HashMap<String, String> getRandomSpell() {
        HashMap<String, String> randomSpell = new HashMap<>();
        Object[] keys = SPELLS.keySet().toArray();
        String randomKey = String.valueOf(keys[random.nextInt(keys.length)]);
        randomSpell.put("eventType", randomKey);
        randomSpell.put("eventDescription", SPELLS.get(randomKey));
        return randomSpell;
    }

}

