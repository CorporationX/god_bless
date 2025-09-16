package school.faang.bjs2_85909;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Вино в чай!");
        hogwartsSpells.addSpellEvent("Фокусы", "Чайка из банки");

        //testing of hogwartsSpells methods
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventByType("Чары"));
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();

    }
}
