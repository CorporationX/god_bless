package school.faang.task_44481;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(1, "Чар", "Зачаровывает предмет");
        HogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразовывает предмет");
        HogwartsSpells.addSpellEvent(3, "Защита", "Защищает от огненной атаки");
        HogwartsSpells.addSpellEvent(4, "Защита", "Защищает от физической атаки атаки");
        HogwartsSpells.addSpellEvent(5, "Чар", "Зачаровывает оппонента");

        HogwartsSpells.printAllSpellEvents();

        SpellEvent spellEventById = HogwartsSpells.getSpellEventById(3);
        System.out.println("SpellEventById: " + spellEventById);

        List<SpellEvent> spellsByType = HogwartsSpells.getSpellsByType("Защита");
        System.out.println("SpellsByType: " + spellsByType);

        HogwartsSpells.deleteSpellEvent(3);
        HogwartsSpells.printAllSpellEvents();
    }
}
