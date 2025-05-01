package catching.events;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чар", "Превращает в легушку");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Чар", "Превращает в осла");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет в газ");

        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(3));

        for (SpellEvent spellEvent : hogwartsSpells.getSpellEventsByType("Чар")) {
            System.out.println(spellEvent);
        }

        hogwartsSpells.deleteSpellEvent(2);

        System.out.println();
        hogwartsSpells.printAllSpellEvents();
    }
}
