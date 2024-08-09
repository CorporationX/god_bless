package faang.school.godbless.java.sql.heroes;

public class App {
    public static void main(String[] args) {

        // Create creatures for Vasia
        Creature pikeman = new Pikeman(Constants.PIKEMAN, 10, 5, 1, 4 );
        Creature swordman = new Swordman(Constants.SWORDMAN, 7, 20, 2, 2 );
        Creature griffin = new Griffin(Constants.GRIFFIN, 5, 40, 30, 10);
        Creature angel = new Angel(Constants.ANGEL, 2, 80, 40, 20);

        Hero heroOne = new Hero("Vasia", "BLACK", 10, 20);
        heroOne.addCreature(pikeman, 10);
        heroOne.addCreature(swordman, 4);
        heroOne.addCreature(griffin, 3);
        heroOne.addCreature(angel, 1);


        // Create creatures for Kolia
        Creature pikeman2 = new Pikeman(Constants.PIKEMAN, 10, 5, 1, 4);
        Creature swordman2 = new Swordman(Constants.SWORDMAN, 7, 20, 2, 2);
        Creature griffin2 = new Griffin(Constants.GRIFFIN, 5, 40, 1, 10);
        Creature angel2 = new Angel(Constants.ANGEL, 2, 80, 40, 20);

        Hero heroTwo = new Hero("Kolia", "WHITE", 10, 20);
        heroTwo.addCreature(pikeman2, 33);
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
