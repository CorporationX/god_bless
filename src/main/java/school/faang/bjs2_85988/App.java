package school.faang.bjs2_85988;

public class App {

    public static void main(String[] args) {
        final HogwartsSpells hogwartsSpells = new HogwartsSpells();
        final String transFiguriya = "Трансфигурация";

        final int spellId =  hogwartsSpells.addSpellEvent(transFiguriya, "Колдует");
        hogwartsSpells.addSpellEvent(transFiguriya, "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");

        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(spellId));

        System.out.println(hogwartsSpells.getSpellEventsByType("some type"));

        System.out.println(hogwartsSpells.getSpellEventsByType(transFiguriya));

        hogwartsSpells.deleteSpellEvent(spellId);

        System.out.println(hogwartsSpells.getSpellEventsByType(transFiguriya));

        System.out.println(hogwartsSpells.getSpellEventById(spellId));
    }
}