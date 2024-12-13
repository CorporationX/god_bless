package school.faang.sprint_1.task_bjs44693;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEvent spellEvent) {
        if (spellById.containsKey(spellEvent.getId())) {
            log.info("spellEvent exist ID = {}", spellEvent.getId());
        } else {
            spellById.put(spellEvent.getId(), spellEvent);
            spellsByType.putIfAbsent(spellEvent.getSpellType(), new ArrayList<>());
            spellsByType.get(spellEvent.getSpellType()).add(spellEvent);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(SpellType spellType) {
        return spellsByType.get(spellType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedSpell = spellById.remove(id);
        if (removedSpell == null) {
            log.info("SpellEvent not exist by Id= {}", id);
        } else {
            SpellType spellType = removedSpell.getSpellType();
            List<SpellEvent> spellEventList = spellsByType.get(spellType);
            spellEventList.remove(removedSpell);
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((k, v) -> System.out.println("Id: " + k + ", Тип: " + v));
    }
}

