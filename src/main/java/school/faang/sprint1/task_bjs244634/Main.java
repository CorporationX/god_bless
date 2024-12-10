package school.faang.sprint1.task_bjs244634;

import java.util.List;

public class Main {

    public static final String HEALTH = "Лечение";
    public static final String ATTACK = "Атака";
    public static final String PROTECTION = "Защита";
    public static final String BUFF = "Бафф";
    public static final String DEBUFF = "Дебафф";

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = getSpells();

        System.out.println(hogwartsSpells.getSpellEventById(1));

        hogwartsSpells.deleteSpellEvent(1);

        List<SpellEvent> healingSpells = hogwartsSpells.getSpellEventsByType(ATTACK);
        System.out.println();
        System.out.println("Вид заклинания: " + ATTACK);
        for (SpellEvent spellEvent : healingSpells) {
            System.out.println(spellEvent);
        }

        System.out.println();
        hogwartsSpells.printAllSpellEvents();
    }

    private static HogwartsSpells getSpells() {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, HEALTH, "Заживление ран");
        hogwartsSpells.addSpellEvent(2, HEALTH, "Исцеляющий Свет");
        hogwartsSpells.addSpellEvent(3, HEALTH, "Восстановление Энергии");
        hogwartsSpells.addSpellEvent(4, ATTACK, "Огненный Взрыв");
        hogwartsSpells.addSpellEvent(5, PROTECTION, "Щит");
        hogwartsSpells.addSpellEvent(6, ATTACK, "Ледяная Стена");
        hogwartsSpells.addSpellEvent(7, BUFF, "Невидимость");
        hogwartsSpells.addSpellEvent(8, DEBUFF, "Проклятие Слабости");
        hogwartsSpells.addSpellEvent(9, BUFF, "Увеличивает защиту");
        return hogwartsSpells;
    }
}
