package school.BJS2_32836;

import java.util.Random;

public class Battlefield {

    public static void main(String[] args) throws InterruptedException {
        buttle();
    }


    private static void buttle() throws InterruptedException {
        Hero hero1 = new Hero("Рома", "Альянс", 50, 1);
        hero1.addCreature(new Angel("Angel", 3, 15, 20, 10), 1);
        hero1.addCreature(new Pikeman("Pikeman", 2, 20, 10, 5), 2);
        Hero hero2 = new Hero("Денис", "Орда", 30, 1);
        hero2.addCreature(new Swordman("Swordan", 2, 10, 30, 20), 1);
        hero2.addCreature(new Angel("Angel", 3, 15, 20, 10), 1);
        Random rand = new Random();
        while (true) {
            int siseArmee_1 = hero1.getArmee().size();
            int siseArmee_2 = hero1.getArmee().size();
            Creature creatureFromHero2 = hero2.getArmee().get(rand.nextInt(siseArmee_2-1));
            Creature creatureFromHero1 = hero1.getArmee().get(rand.nextInt(siseArmee_1-1));
            creatureFromHero1.attackEnemy(creatureFromHero2);
            System.out.printf("Герой %s бьет Героя 2", creatureFromHero1.getName());
            System.out.println();
            System.out.println(creatureFromHero2.getHealth());
            Thread.sleep(300);
            if (creatureFromHero2.getHealth() < 0) {
                hero2.getArmee().remove(creatureFromHero2);
                if (hero2.getArmee().isEmpty()) {
                    System.out.println(hero1.getName() + " Победил");
                    break;
                }
            } else {
                creatureFromHero2.attackEnemy(creatureFromHero1);
                System.out.printf("Герой %s бьет Героя 1", creatureFromHero2.getName());
                System.out.println();
                System.out.println(creatureFromHero2.getHealth());
            }
            Thread.sleep(300);
            if (creatureFromHero1.getHealth() < 0) {
                hero1.getArmee().remove(creatureFromHero1);
                if (hero1.getArmee().isEmpty()) {
                    System.out.println(hero2.getName() + " Победил");
                   break;
                }
            }

        }
    }

}