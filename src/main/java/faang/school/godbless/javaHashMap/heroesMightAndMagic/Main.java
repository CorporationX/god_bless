package faang.school.godbless.javaHashMap.heroesMightAndMagic;
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Garod", "people", 569, 12);
        hero.addCreature(new Swordman(), 10);
        hero.addCreature(new Griffin(), 4);
        hero.addCreature(new Angel(), 5);

        Hero hero1 = new Hero("Krig", "orks", 643, 13);
        hero1.addCreature(new Pikerman(), 7);
        hero1.addCreature(new Griffin(), 3);
        hero1.addCreature(new Griffin(), 2);

        Battlefield battlefield = new Battlefield(hero, hero1);
        System.out.println(battlefield.battle());
    }
}