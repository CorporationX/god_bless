package school.faang.bjs2_79744;

public class Hogwarts {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent("атака", "дает урон огнем");
        spells.addSpellEvent("защита", "создает непробиваемое поле");
        spells.addSpellEvent("укрытие", "наделяет невидимостью");

        System.out.println(spells.getSpellEventById(1));

        System.out.println(spells.getSpellEventsByType("атака"));
        spells.deleteSpellEvent(3);

        spells.printAllSpellEvents();
    }
}
