package school.faang.bjs2_57324;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent("Защита", "Защищает от атак");
        spells.addSpellEvent("Трансфигурация", "Преоразует предмет");
        spells.printAllSpellEvents();
        System.out.println(spells.getSpellEventById(1));
        System.out.println(spells.getSpellEventsByType("Трансфигурация"));
        spells.deleteSpellEvent(1);
        spells.addSpellEvent("Атака", "Совершает атаку");
        spells.printAllSpellEvents();
    }

}
