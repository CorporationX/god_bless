package school.faang.task_45447;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Spell {

    protected static final Map<String, String> SPELL;

    private static Random random = new Random();

    static {
        Map<String, String> spells = new HashMap<>();
        spells.put("Fireball", "Launches a fiery ball that explodes on impact, dealing damage " +
                "to enemies within a radius.");
        spells.put("Frost Nova", "Creates a burst of freezing energy, slowing or immobilizing nearby enemies.");
        spells.put("Lightning Bolt", "Fires a bolt of lightning that strikes a single target with immense force.");
        spells.put("Healing Touch", "Restores health to an ally or the caster over a short period of time.");
        spells.put("Arcane Shield", "Surrounds the caster with a protective shield that absorbs " +
                "a certain amount of damage.");
        spells.put("Summon Familiar", "Calls forth a magical creature to assist the caster in battle or exploration.");
        spells.put("Invisibility", "Makes the caster invisible for a limited time, allowing them to avoid detection.");
        spells.put("Teleport", "Instantly transports the caster to a chosen location within a certain range.");
        spells.put("Dispel Magic", "Removes magical effects or curses from a target.");
        spells.put("Charm Person", "Enchants a person, temporarily influencing their actions to favor the caster.");
        spells.put("Shield of Light", "Creates a radiant barrier that reflects a portion of incoming damage " +
                "back to attackers.");
        spells.put("Earthquake", "Causes the ground to tremble violently, damaging and knocking down " +
                "enemies in the area.");
        spells.put("Wind Blast", "Unleashes a powerful gust of wind, pushing enemies away and clearing obstacles.");
        spells.put("Shadow Step", "Allows the caster to move instantly to a shadowy location, avoiding " +
                "obstacles and enemies.");
        spells.put("Mind Spike", "Assaults an enemy's mind with psychic energy, causing damage and disorientation.");
        spells.put("Time Warp", "Temporarily accelerates the caster’s and their allies' movements and actions.");
        spells.put("Poison Cloud", "Summons a cloud of toxic gas that damages and weakens enemies over time.");
        spells.put("Levitate", "Lifts the caster or a target into the air, allowing them to hover above ground.");
        spells.put("Stone Skin", "Hardens the caster's skin like stone, increasing resistance to physical damage.");
        spells.put("Phoenix Flame", "Summons the fiery power of a phoenix, burning enemies and " +
                "healing allies nearby.");
        SPELL = Collections.unmodifiableMap(spells);
    }

    public static Map<String, String> getRandomSpell() {
        Map<String, String> randomSpell = new HashMap<>();
        Object[] keys = SPELL.keySet().toArray();
        String randomKey = String.valueOf(keys[random.nextInt(keys.length)]);
        randomSpell.put("eventType", randomKey);
        randomSpell.put("eventDescription", SPELL.get(randomKey));
        return randomSpell;
    }
}
