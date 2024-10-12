package school.faang.BJS2_32902;


import school.faang.BJS2_32902.entity.Angel;
import school.faang.BJS2_32902.entity.Griffin;
import school.faang.BJS2_32902.entity.Pikeman;
import school.faang.BJS2_32902.entity.Swordman;

public class Main {

    public static void main(String[] args) {
        Hero hero1 = new Hero("Sir Petr", "Castle");
        Hero hero2 = new Hero("Lord Vania", "Necropolis");

        hero1.addCreature(new Pikeman(), randomNumber(1, 78));
        hero1.addCreature(new Griffin(), randomNumber(5, 61));

        hero2.addCreature(new Swordman(), randomNumber(21, 71));
        hero2.addCreature(new Angel(), randomNumber(3, 17));

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("Win: " + winner.getName());
    }

    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

}
