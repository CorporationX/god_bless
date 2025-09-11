package school.faang.bjs2_85988;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HogwartsSpells {

    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELLS_BY_TYPE = new HashMap<>();

    public void deleteSpellEvent(int id) {
        final SpellEvent spellEvent = SPELL_BY_ID.remove(id);

        if (spellEvent != null) {
            SPELLS_BY_TYPE.get(spellEvent.getEventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : SPELL_BY_ID.values()) {
            System.out.println(spellEvent);
        }
    }

    @SneakyThrows
    public int addSpellEvent(@NonNull String eventType, @NonNull String actionDescription) {
        final int randomBound = 1000;
        final Random random = new Random();
        int spellId = random.nextInt(randomBound);

        int maxTry = 0;
        while (SPELL_BY_ID.keySet().contains(spellId)) {
            spellId = random.nextInt(randomBound);

            if (maxTry == randomBound) {
                throw new Exception("Spell map is full. Delete some at first!");
            }
            maxTry++;
        }
        final int finalSpellId = spellId;

        SPELL_BY_ID.put(spellId, new SpellEvent(spellId, eventType, actionDescription));

        SPELLS_BY_TYPE.computeIfAbsent(
                SPELL_BY_ID.get(finalSpellId).getEventType(),
                key -> new ArrayList<>()).add(SPELL_BY_ID.get(finalSpellId));

        return finalSpellId;
    }

    public SpellEvent getSpellEventById(int id) {
        if (SPELL_BY_ID.get(id) == null) {
            throw new NullPointerException("Spell by id %d not found".formatted(id));
        }

        return SPELL_BY_ID.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (SPELLS_BY_TYPE.get(eventType) == null) {
            return new ArrayList<>();
        } else {
            return SPELLS_BY_TYPE.get(eventType);
        }
    }
}