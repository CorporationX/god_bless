package faang.school.godbless.java.sql.heroes;

public class App {
    public static void main(String[] args) {

        Creature pikeman = new Pikeman();
        Creature swordman = new Swordman();
        Creature griffin = new Griffin();
        Creature angel = new Angel();

        Hero heroOne = new Hero("Vasia", "BLACK", 10, 20);
        heroOne.addCreature(pikeman, 11);
        heroOne.addCreature(swordman, 4);
        heroOne.addCreature(griffin, 3);
        heroOne.addCreature(angel, 1);

        Creature pikeman2 = new Pikeman();
        Creature swordman2 = new Swordman();
        Creature griffin2 = new Griffin();
        Creature angel2 = new Angel();

        Hero heroTwo = new Hero("Kolia", "WHITE", 10, 20);
        heroTwo.addCreature(pikeman2, 9);
        heroTwo.addCreature(swordman2, 2);
        heroTwo.addCreature(griffin2, 5);
        heroTwo.addCreature(angel2, 2);

        Battlefield battlefield = new Battlefield(heroOne, heroTwo);
        Hero winner = battlefield.battle();
        System.out.println("______________________________________");
        System.out.printf("%s from fraction %s wins the battle!%n", winner.getName(), winner.getFraction());
        winner.getArmy();
        System.out.println("--------------------------------------");
    }
}
