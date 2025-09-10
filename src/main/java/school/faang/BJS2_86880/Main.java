package school.faang.BJS2_86880;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Test:
        HogwartsSpells.addSpellEvent("Атака по-деревенски", "Дать по репе");
        HogwartsSpells.addSpellEvent("Атака по-деревенски", "Зарядить в бубен");
        HogwartsSpells.addSpellEvent("Атака по-боксерски", "Нанести кросс");
        HogwartsSpells.addSpellEvent("Атака по-боксерски", "Нанести апперкот");
        HogwartsSpells.addSpellEvent("Атака по-борцовски", "Сделать кимуру");
        HogwartsSpells.addSpellEvent("Атака по-борцовски", "Сделать рычаг локтя");

        SpellEvent spellEventById = HogwartsSpells.getSpellEventById(3);
        System.out.println(spellEventById.getAction());

        List<SpellEvent> spellEventsByType = HogwartsSpells.getSpellEventsByType("Атака по-борцовски");
        for (SpellEvent spellEvent : spellEventsByType) {
            System.out.println(spellEvent.getAction());
        }

        System.out.println("До удаления:");
        HogwartsSpells.printAllSpellEvents();

        HogwartsSpells.deleteSpellEvent(4);
        HogwartsSpells.deleteSpellEvent(5);
        HogwartsSpells.deleteSpellEvent(6);

        System.out.println("После удаления:");
        HogwartsSpells.printAllSpellEvents();
    }
}
