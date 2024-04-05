package HeroesofMightandMagic;

public class Main {
    public static void main(String[] args) {
        Griffin griffin = new Griffin();
        Angel angel = new Angel();
        Hero hero1 = new Hero("Nikita", "4141", 100, 3);
        Hero hero2 = new Hero("Max", "4242", 1000, 100);
        hero1.addCreature(griffin, 2);
        hero2.addCreature(angel, 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        System.out.println(battlefield.battle());
    }
}
