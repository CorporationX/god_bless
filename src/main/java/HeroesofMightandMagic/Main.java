package HeroesofMightandMagic;

public class Main {
    public static void main(String[] args) {
        Griffin griffin = new Griffin();
        Angel angel = new Angel();
        Hero hero1 = new Hero("Nikita", "4141", 100, 3);
        Hero hero2 = new Hero("Max", "4242", 1000, 100);
        hero1.addCreature(griffin, 2);
        hero1.addCreature(angel, 1);
        hero2.addCreature(angel, 1);

        System.out.println(hero1.getArmy());
        hero1.removeCreature(angel, 1);
        System.out.println(hero1.getArmy());
        hero1.removeCreature(griffin, 1);
        System.out.println(hero1.getArmy());

        Battlefield battlefield = new Battlefield(hero1, hero2);
        System.out.println(battlefield.battle());
    }
}
