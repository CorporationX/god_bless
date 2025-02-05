package school.faang.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    /**
     * Создает объект класса SpellEvent, автоматически генерирует уникальный ID, добавляет событие в обе HashMap;
     * @param eventType - тип заклинания (например, “Чар”, “Трансфигурация”, “Защита”);
     * @param actionDescription - строка, которая описывает действие заклинания (например, "Защищает от атак" или "Преобразует предмет").
     */
    public void addSpellEvent(String eventType, String actionDescription) {

    }

}
