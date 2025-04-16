package school.faang.catchevents;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellDescriptionByName = new HashMap<>();
    private static int generateId = 1;

    public void addSpellEvent(String magicSpell, String spellDescription) {
        int id = getGenerateId();
        SpellEvent newSpell = new SpellEvent(id, magicSpell, spellDescription);
        spellById.put(id, newSpell);
        spellDescriptionByName.computeIfAbsent(magicSpell, newKey -> new ArrayList<>()).add(newSpell);
    }

    private int getGenerateId() {
        return generateId++;
    }

    public SpellEvent getSpellById(int id) {
        SpellEvent spell = spellById.get(id);
        if (spell == null) {
            log.warn("Заклинание ID {} не найдено", id);
        }
        return spell;
    }

    public List<SpellEvent> getSpellDescriptionByName(String magicSpell) {
        return spellDescriptionByName.get(magicSpell);
    }

    public boolean deleteSpell(int id) {
        SpellEvent event = spellById.remove(id);
        if (event == null) {
            log.warn("Заклинание {} не найдено", id);
            return false;
        }

        List<SpellEvent> eventsOfType = spellDescriptionByName.get(event.getMagicSpell());
        if (eventsOfType != null) {
            eventsOfType.remove(event);
            if (eventsOfType.isEmpty()) {
                spellDescriptionByName.remove(event.getMagicSpell());
            }
        }
        log.info("Заклинание с ID {} успешно удалено", id);
        return true;
    }

    public void printAllMagicSpells() {
        if (spellById.isEmpty()) {
            System.out.println("Заклинания не найдены");
            return;
        }

        for (SpellEvent event : spellById.values()) {
            System.out.printf("ID: %d, Заклинание: %s, Описание: %s%n",
                    event.getId(),
                    event.getMagicSpell(),
                    event.getSpellDescription());
        }
    }
}
