package school.faang.bjs2_86860;

public class Main {
    private static final int SEARCH_SPELL_ID = 4;
    private static final int DELETE_SPELL_ID = 2;
    private static final String EVENT_TYPE = "Вингардиум левиосса";

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        try {
            hogwartsSpells.addSpellEvents("Вингардиум левиосса", "Заставляет предмет летать");
            hogwartsSpells.addSpellEvents("Алохаморе", "Открывает все замки");
            hogwartsSpells.addSpellEvents("Экспекто патронум", "Вызов Патронуса");
            hogwartsSpells.addSpellEvents("Экспеллиармус", "Заклинание разоружения");
            hogwartsSpells.addSpellEvents("Редукто", "Взрывающее заклятье");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Получение заклинания по id: " + hogwartsSpells.getSpellEventById(SEARCH_SPELL_ID));
        System.out.println("Получение списка событий по типу: " + hogwartsSpells.getSpellEventsByType(EVENT_TYPE));

        hogwartsSpells.deleteSpellEvent(DELETE_SPELL_ID);
        hogwartsSpells.printAllSpellEvents();
    }
}
