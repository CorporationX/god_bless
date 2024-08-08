package faang.school.godbless.battle;

import java.util.Random;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    private void attackInBattle(Hero hero1, Hero hero2, int hero1ArmySize, int hero2ArmySize) {
        Random random = new Random();
        hero1.getArmy().get(random.nextInt(hero1ArmySize)).attack(hero2.getArmy().get(random.nextInt(hero2ArmySize)));
        hero2.checkArmy();
        System.out.println(hero1.getName() + " attacks " + hero2.getName() + ":");
        hero2.printArmy();
    }

    public Hero battle() {
        System.out.println("The battle is started!");
        hero1.printArmy();
        hero2.printArmy();

        int hero1ArmySize = hero1.getArmy().size();
        int hero2ArmySize = hero2.getArmy().size();

        while (!hero1.getArmy().isEmpty() && !hero2.getArmy().isEmpty()) {
            attackInBattle(hero1, hero2, hero1ArmySize, hero2ArmySize);
            hero1ArmySize = hero1.getArmy().size();
            hero2ArmySize = hero2.getArmy().size();

            attackInBattle(hero2, hero1, hero2ArmySize, hero1ArmySize);
            hero1ArmySize = hero1.getArmy().size();
            hero2ArmySize = hero2.getArmy().size();
        }
        if (hero1.getArmy().isEmpty()) {
            hero2.increaseLevel();
            System.out.println("The battle is finished!");
            return hero2;
        } else {
            hero1.increaseLevel();
            System.out.println("The battle is finished!");
            return hero1;
        }
    }

    public static void main(String[] args) {
        Hero hero1 = new Hero("Tony");
        Hero hero2 = new Hero("Mark");

        hero1.addCreature(new Pikeman("pikeman"), 2);
        hero1.addCreature(new Griffin("griffin"), 2);
        hero1.addCreature(new Angel("angel"), 1);
        hero1.addCreature(new Swordman("swordman"), 1);

        hero2.addCreature(new Pikeman("pikeman"),   1);
        hero2.addCreature(new Griffin("griffin"),   1);
        hero2.addCreature(new Angel("angel"),   2);
        hero2.addCreature(new Swordman("swordman"), 2);

        hero2.removeCreature(new Angel("angel"), 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("The winner is " + winner);
    }
}
