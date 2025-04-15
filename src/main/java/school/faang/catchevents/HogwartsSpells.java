package school.faang.catchevents;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    Map<Integer, SpellEvent> spellStorageById = new HashMap<>();
    Map<String, List<SpellEvent>> spellDescriptionStorageByName = new HashMap<>();
    private int generateId = 1;

    public void addSpellEvent(String magicSpell, String spellDescription) {
        int id = getGenerateId();
        SpellEvent newSpell = new SpellEvent(id, magicSpell, spellDescription);
        spellStorageById.put(id, newSpell);
        spellDescriptionStorageByName.computeIfAbsent(magicSpell, newKey -> new ArrayList<>()).add(newSpell);
    }

    public int getGenerateId() {
        return generateId++;
    }

    public SpellEvent getSpellById(int id) {
        SpellEvent spell = spellStorageById.get(id);
        if (spell == null) {
            log.warn("Заклинание ID {} не найдено", id);
        }
        return spell;
    }

    public List<SpellEvent> getSpellDescriptionByName(String magicSpell) {
        return spellDescriptionStorageByName.get(magicSpell);
    }

    public boolean deleteSpell(int id) {
        SpellEvent event = spellStorageById.remove(id);
        if (event == null) {
            log.warn("Заклинание {} не найдено", id);
            return false;
        }

        List<SpellEvent> eventsOfType = spellDescriptionStorageByName.get(event.getMagicSpell());
        if (eventsOfType != null) {
            eventsOfType.remove(event);
            if (eventsOfType.isEmpty()) {
                spellDescriptionStorageByName.remove(event.getMagicSpell());
            }
        }
        log.info("Заклинание с ID {} успешно удалено", id);
        return true;
    }

    public void printAllMagicSpells() {
        if (spellStorageById.isEmpty()) {
            System.out.println("Заклинания не найдены");
            return;
        }

        for (SpellEvent event : spellStorageById.values()) {
            System.out.printf("ID: %d, Заклинание: %s, Описание: %s%n",
                    event.getId(),
                    event.getMagicSpell(),
                    event.getSpellDescription());
        }
    }
}
