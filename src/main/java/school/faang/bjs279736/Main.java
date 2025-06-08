package school.faang.bjs279736;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hs = new HogwartsSpells();

        hs.addSpellEvent("Чар", "Защищает от атак");
        hs.addSpellEvent("Трансфигурация", "Преобразует предмет");

        hs.printAllSpellEvents();

        hs.getSpellEventsByType("kklh;j;lj");
        hs.getSpellEventsByType("Трансфигурация");

        hs.getSpellEventById(2);

        hs.deleteSpellEvent(1);// Исправить!!!!!
        hs.printAllSpellEvents();
    }
}
