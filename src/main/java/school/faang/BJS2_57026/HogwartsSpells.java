package school.faang.BJS2_57026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static final AtomicInteger counter = new AtomicInteger(1);

    public static void addSpellEvent(String eventType, String actionDescription) {
        int id = counter.getAndIncrement();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.merge(eventType, new ArrayList<>(List.of(spellEvent)), (existingList, newList) -> {
            existingList.add(spellEvent);
            return existingList;
        });
    }

    public static void getSpellEventById(int id) {
        SpellEvent spell = spellById.get(id);

        if (spell != null) {
            System.out.printf("🪄 Id: %d | EventType: %s | Action: %s%n",
                    spell.getId(), spell.getEventType(), spell.getAction());
        } else {
            System.out.println("❌ No spell found with this ID.");
        }
    }

    public static void getSpellEventsByType(String eventType) {
        List<SpellEvent> spells = spellsByType.get(eventType);

        if (spells == null || spells.isEmpty()) {
            System.out.printf("❌ No spells found for type \"%s\".%n", eventType);
            return;
        }

        System.out.printf("📜 Spells of type \"%s\":%n", eventType);
        spells.forEach(spell ->
                System.out.printf("🪄 Id: %d | Action: %s%n", spell.getId(), spell.getAction())
        );
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spell = spellById.get(id);

        if (spell == null) {
            System.out.println("❌ No spell found with this ID.");
            return;
        }

        spellById.remove(id);
        List<SpellEvent> spellList = spellsByType.get(spell.getEventType());

        if (spellList == null) {
            return;
        }

        spellList.remove(spell);

        if (spellList.isEmpty()) {
            spellsByType.remove(spell.getEventType());
        }
    }

    public static void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("❌ No spells in the system.");
            return;
        }

        System.out.println("\n📜 All spells in the system:");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<Integer, SpellEvent> spell : spellById.entrySet()) {
            System.out.printf("🪄 Id: %d | EventType: %s | Action: %s%n",
                    spell.getValue().getId(), spell.getValue().getEventType(), spell.getValue().getAction());
        }

        System.out.println("-------------------------------------------------");

        if (spellsByType.isEmpty()) {
            System.out.println("❌ No spell types in the system.");
            return;
        }

        System.out.println("\n📜 All spell types in the system:");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<String, List<SpellEvent>> typeSpell : spellsByType.entrySet()) {
            System.out.printf("\n📜 Spell Type: %s%n", typeSpell.getKey());
            typeSpell.getValue().forEach(item -> {
                System.out.printf("🪄 Id: %d | Action: %s%n",
                        item.getId(), item.getAction());
            });
        }
        System.out.println("-------------------------------------------------");
    }
}
