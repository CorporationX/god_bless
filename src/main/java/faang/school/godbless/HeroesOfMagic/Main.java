package faang.school.godbless.HeroesOfMagic;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Hero1", "people", 25, 10);
        Hero hero2 = new Hero("Hero2", "noPeople", 15, 8);

        hero1.addCreature(new Pikeman(10));
        hero1.addCreature(new Griffin(2));
        hero1.getArmy();
        System.out.println("Удаляем бойцов из армии");
        hero1.removeCreature(new Pikeman(15));
        hero1.getArmy();

        hero2.addCreature(new Pikeman(5));
        hero2.addCreature(new Swordman(7));
        hero2.getArmy();

        new Battlefield().battle(hero1, hero2);
    }
}
