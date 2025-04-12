package school.faang.cathingspells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById;
    private HashMap<String, List<SpellEvent>> spellsByType;

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        Integer uniqueId = Integer.parseInt(UUID.randomUUID().toString());
        SpellEvent spellEvent = new SpellEvent(uniqueId, eventType, actionDescription);
        spellById.put(uniqueId, spellEvent);
        List<SpellEvent> thisTypeSpellEvents = new ArrayList<>();
        if(spellsByType.containsKey(eventType)){
            thisTypeSpellEvents.addAll(spellsByType.get(eventType));
        }
        thisTypeSpellEvents.add(spellEvent);
        spellsByType.put(eventType, thisTypeSpellEvents);
        return spellEvent;
    }



    getSpellEventById(int id): возвращает событие заклинания по его ID;

    getSpellEventsByType(String eventType): возвращает список событий заклинаний по типу;

    deleteSpellEvent(int id): удаляет событие заклинания по его ID из обеих HashMap;

    printAllSpellEvents(): выводит информацию о всех событиях заклинаний в консоль,
    используя обход элементов Entry в HashMap spellById. Выведите ID, тип и данные каждого события.
}
