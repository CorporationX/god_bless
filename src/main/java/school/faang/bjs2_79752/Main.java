package school.faang.bjs2_79752;

public class Main {
    public static void main(String[] args) {
        HogwartsSpell hogwartsSpell = new HogwartsSpell();

        hogwartsSpell.addSpellEvent("Fire", "FireBall");
        hogwartsSpell.addSpellEvent("Fire", "SomethingFire");
        hogwartsSpell.addSpellEvent("Transfiguration", "Teleport");
        hogwartsSpell.printAllSpellEvents();

        System.out.println(hogwartsSpell.getSpellEventById(new SpellId("Fire", "SomethingFire").hashCode()));
        System.out.println(hogwartsSpell.getSpellEventsByType("Fire"));

        hogwartsSpell.deleteSpellEvent(new SpellId("Fire", "SomethingFire").hashCode());
        hogwartsSpell.printAllSpellEvents();
    }
}