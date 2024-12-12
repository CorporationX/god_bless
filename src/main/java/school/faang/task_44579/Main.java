package school.faang.task_44579;

public class Main {
    public static final int FIRST_SPELL_ID = 1;
    public static final int SECOND_SPELL_ID = 2;
    public static final int THIRD_SPELL_ID = 3;
    public static final int FOURTH_SPELL_ID = 4;
    public static final String SPELL = "Чар";

    public static void main(String[] args) {

        HogwartsSpells spellsSystem = new HogwartsSpells();

        spellsSystem.addSpellEvent(FIRST_SPELL_ID, SPELL, "Защищает от атак");
        spellsSystem.addSpellEvent(SECOND_SPELL_ID, "Трансфигурация", "Преобразует предмет");
        spellsSystem.addSpellEvent(THIRD_SPELL_ID, SPELL, "Лечит раны");
        spellsSystem.addSpellEvent(FOURTH_SPELL_ID, SPELL, "Удаляет память");

        System.out.printf("-- Получено заклинание по ID %s: %s%n",
                FIRST_SPELL_ID,
                spellsSystem.getSpellEventById(FIRST_SPELL_ID));

        System.out.printf("-- Список заклинаний типа %s: %s%n", SPELL, spellsSystem.getSpellEventsByType(SPELL));

        System.out.println("-- Удаление:");
        spellsSystem.deleteSpellEvent(FIRST_SPELL_ID);

        System.out.println("-- Все заклинания:");
        spellsSystem.printAllSpellEvents();
    }
}
