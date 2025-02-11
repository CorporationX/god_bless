package school.faang.BJS2_57026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();


    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);

        this.spellById.put(spellEvent.getId(), spellEvent);
        this.spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        SpellEvent spell = this.spellById.get(id);

        if (spell != null) {
            System.out.printf("🪄 Id: %d | EventType: %s | Action: %s%n",
                    spell.getId(), spell.getEventType(), spell.getAction());
        } else {
            System.out.println("❌ No spell found with this ID.");
        }
    }

    public void getSpellEventsByType(String eventType) {
        List<SpellEvent> spells = this.spellsByType.get(eventType);

        if (spells == null || spells.isEmpty()) {
            System.out.printf("❌ No spells found for type \"%s\".%n", eventType);
            return;
        }

        System.out.printf("📜 Spells of type \"%s\":%n", eventType);
        spells.forEach(spell ->
                System.out.printf("🪄 Id: %d | Action: %s%n", spell.getId(), spell.getAction())
        );
    }

    public void deleteSpellEvent(int id) {
        var removedSpell = spellById.remove(id);
        if (removedSpell == null) {
            return;
        }

        var eventType = removedSpell.getEventType();
        if (eventType == null) {
            return;
        }

        var spellEvents = spellsByType.get(eventType);
        if (spellEvents == null) {
            return;
        }

        spellEvents.remove(removedSpell);
        if (spellEvents.isEmpty()) {
            spellsByType.remove(eventType);
        }
    }

    public void printAllSpellEvents() {
        if (this.spellById.isEmpty()) {
            System.out.println("❌ No spells in the system.");
            return;
        }

        System.out.println("\n📜 All spells in the system:");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<Integer, SpellEvent> spell : this.spellById.entrySet()) {
            System.out.printf("🪄 Id: %d | EventType: %s | Action: %s%n",
                    spell.getValue().getId(), spell.getValue().getEventType(), spell.getValue().getAction());
        }

        System.out.println("-------------------------------------------------");

        if (this.spellsByType.isEmpty()) {
            System.out.println("❌ No spell types in the system.");
            return;
        }

        System.out.println("\n📜 All spell types in the system:");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<String, List<SpellEvent>> typeSpell : this.spellsByType.entrySet()) {
            System.out.printf("\n📜 Spell Type: %s%n", typeSpell.getKey());
            typeSpell.getValue().forEach(item -> {
                System.out.printf("🪄 Id: %d | Action: %s%n",
                        item.getId(), item.getAction());
            });
        }
        System.out.println("-------------------------------------------------");
    }
}
