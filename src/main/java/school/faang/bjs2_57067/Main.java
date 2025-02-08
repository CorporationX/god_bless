package school.faang.bjs2_57067;

public class Main {
    public static void main(String[] args) {
        try {
            HogwartsSpells hs = new HogwartsSpells();
            hs.addSpellEvent("Трансфигурация", "Преобразует предмет");
            hs.addSpellEvent("Защита", "Защищает от атак");
            hs.printAllSpellEvents();
            System.out.println(hs.getSpellEventById(2));
            System.out.println(hs.getSpellEventsByType("Трансфигурация"));
            hs.deleteSpellEvent(1);
            hs.printAllSpellEvents();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
