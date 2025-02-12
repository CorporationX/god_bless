package school.faang;

import java.util.*;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int universeId;

    public HogwartsSpells(Map<Integer, SpellEvent> spellById, Map<String, List<SpellEvent>> spellsByType, int universeId) {
        this.spellById = spellById;
        this.spellsByType = spellsByType;
        this.universeId = universeId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HogwartsSpells that = (HogwartsSpells) o;
        return Objects.equals(spellById, that.spellById) && Objects.equals(spellsByType, that.spellsByType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spellById, spellsByType);
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(universeId, eventType, actionDescription);
        spellById.put(universeId, spellEvent);
        universeId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {


    }

    public void printAllSpellEvents() {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        for ()
    }


}
