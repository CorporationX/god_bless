package school.faang.catchingevents;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {

    }

    public void getSpellEventById(int id) {

    }

    public void getSpellEventsByType(String eventType) {

    }

    public void deleteSpellEvent(int id) {

    }

    public void printAllSpellEvents() {

    }
}
