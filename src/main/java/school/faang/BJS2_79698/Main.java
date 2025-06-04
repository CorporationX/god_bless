package school.faang.BJS2_79698;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent(EventType.ENCHANTMENT, "Защищает от атак");
        spells.addSpellEvent(EventType.TRANSFIGURATION, "Преобразует предмет");

        SpellEvent spellEvent = spells.getSpellEventsByType(EventType.TRANSFIGURATION).stream().findFirst()
                .orElseThrow(() -> new NoSuchElementException("Нет заклинаний данного типа"));
        System.out.println("Тест поиска по id: " + spells.getSpellEventById(spellEvent.getId()));
        spells.deleteSpellEvent(spellEvent.getId());

        spells.printAllSpellEvents();
    }
}
