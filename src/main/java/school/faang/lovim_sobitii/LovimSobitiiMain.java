package school.faang.lovim_sobitii;

public class LovimSobitiiMain {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("chari", "biet po licu");
        spells.addSpellEvent("Transfiguration", "prevrashaet v penek");
        spells.addSpellEvent("defense", "nakidivaet shield");
        spells.addSpellEvent("chari", "pinok");
        spells.addSpellEvent("Transfiguration", "prevrashaet v kota");

        spells.printAllSpellEvents();

        System.out.println("---------------------------------------------");

        System.out.println(spells.getSpellEventsByType("chari"));

        System.out.println("---------------------------------------------");

        System.out.println(spells.getSpellEventById(3));

        System.out.println("---------------------------------------------");

        spells.addSpellEvent("defense", "def + 100");

        spells.printAllSpellEvents();

        System.out.println("---------------------------------------------");

        spells.deleteSpellEvent(6);

        spells.printAllSpellEvents();

    }
}
