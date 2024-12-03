package school.faang.task_44481;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чар", "Зачаровывает предмет");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразовывает предмет");
        hogwartsSpells.addSpellEvent(3, "Защита", "Защищает от огненной атаки");
        hogwartsSpells.addSpellEvent(4, "Защита", "Защищает от физической атаки атаки");
        hogwartsSpells.addSpellEvent(5, "Чар", "Зачаровывает оппонента");

        hogwartsSpells.printAllSpellEvents();

        SpellEvent spellEventById = hogwartsSpells.getSpellEventById(3);
        System.out.println("SpellEventById: " + spellEventById);

        List<SpellEvent> spellsByType = hogwartsSpells.getSpellsByType("Защита");
        System.out.println("SpellsByType: " + spellsByType);

        hogwartsSpells.deleteSpellEvent(3);
        hogwartsSpells.printAllSpellEvents();
    }
}
