package school.faang.сatchingevents79988;


import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращение в ящерицу");
        hogwartsSpells.addSpellEvent("Чары", "Приворожить");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращение в собаку");
        hogwartsSpells.addSpellEvent("Чары", "Чары удачи");
        hogwartsSpells.addSpellEvent("Защита", "Защита от ядов");
        hogwartsSpells.addSpellEvent("Защита", "Защита от увечий");
        hogwartsSpells.addSpellEvent("Защита", "Защита от проклятий");
        hogwartsSpells.addSpellEvent("Чары", "Востановление здоровья");
        hogwartsSpells.addSpellEvent("Телепортация", "Телепортация на работу");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Превращение в програмиста Java");

        for (Map.Entry<Integer, SpellEvent> entry : hogwartsSpells.getSpellById().entrySet()) {
            System.out.println(entry);
        }
        System.out.println("  ");
        for (Map.Entry<String, List<SpellEvent>> entry : hogwartsSpells.getSpellsByType().entrySet()) {
            System.out.println(entry);
        }
        System.out.println("  ");

        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventsByType("Чары"));
        System.out.println("  ");

        hogwartsSpells.deleteSpellEvent(6);
        hogwartsSpells.deleteSpellEvent(9);
        for (Map.Entry<String, List<SpellEvent>> entry : hogwartsSpells.getSpellsByType().entrySet()) {
            System.out.println(entry);
        }
        System.out.println("  ");
        for (Map.Entry<Integer, SpellEvent> entry : hogwartsSpells.getSpellById().entrySet()) {
            System.out.println(entry);
        }
        System.out.println("  ");
        hogwartsSpells.printAllSpellEvents();
    }
}
