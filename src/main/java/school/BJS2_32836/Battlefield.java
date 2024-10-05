package school.BJS2_32836;

import java.util.Random;

public class Battlefield {

    public static void main(String[] args) throws InterruptedException {
        buttle();
    }

    /*
    Справка по игре:
    Для каждого героя создаем армию состоящую из разных существ.
    Выбираем им параметры, все параметры участвуют в боевых действиях.
    Для каждого существа прописаны отдельные условия нанесения урона.
    Можно выбрать точное число созданных экземпляров существ, а можно предоставить выбор рандому, как в примере.
    При убийстве существа, существо, которое нанесло смертельную атаку повышает уровень на 1, что так-же влияет на нанесение урона.

    Приятной игры. Да победит сильнейший.
     */
    private static void buttle() throws InterruptedException {
        Random rand = new Random();
        Hero hero1 = new Hero("Рома", "Альянс", 50, 1);
        hero1.addCreature(new Pikeman("Pikeman", 3, 8, 20, 10), rand.nextInt(4) + 1);
        hero1.addCreature(new Angel("Angel", 2, 25, 15, 5), rand.nextInt(3) + 1);
        hero1.addCreature(new Griffin("Griffin", 5, 20, 45, 10), 2);
        Hero hero2 = new Hero("Костя", "Орда", 30, 1);
        hero2.addCreature(new Griffin("Griffin", 2, 15, 30, 20), 1);
        hero2.addCreature(new Angel("Angel", 3, 20, 20, 10), rand.nextInt(2) + 1);
        hero2.addCreature(new Swordman("Swordman", 4, 15, 10, 30), rand.nextInt(5) + 1);
        while (true) {
            Creature creatureFromHero2 = getCreatureFromArmeeHero(hero2);
            Creature creatureFromHero1 = getCreatureFromArmeeHero(hero1);
            creatureFromHero1.attackEnemy(creatureFromHero2,hero1,hero2);
            checkHelthStatusOfCreature(creatureFromHero2, hero2);
            if (hero2.getArmee().isEmpty()) {
                System.out.println(hero1.getName() + " Победил");
                break;
            } else {
                creatureFromHero2.attackEnemy(creatureFromHero1,hero2,hero1);
                checkHelthStatusOfCreature(creatureFromHero1, hero1);
                if (hero1.getArmee().isEmpty()) {
                    System.out.println(hero2.getName() + " Победил");
                    break;
                }
            }
        }
    }


    private static Creature getCreatureFromArmeeHero(Hero hero) {
        Random rand = new Random();
        if (hero.getArmee().size() == 1) {
            return hero.getArmee().get(0);
        } else
            return hero.getArmee().get(rand.nextInt(hero.getArmee().size()));
    }

    private static Creature checkHelthStatusOfCreature(Creature creature, Hero hero) throws InterruptedException {
        if (creature.getHealth() <= 0) {
            System.out.printf("Существо %s из Армии %s убито", creature.getName(), hero.getName());
            hero.getArmee().remove(creature);
            System.out.println();
            if(!hero.getArmee().isEmpty()) {
                return getCreatureFromArmeeHero(hero);
            }
        } else  {
            System.out.printf("Здоровье существа %s теперь равно %d", creature.getName(), creature.getHealth());
            System.out.println();
            Thread.sleep(500);
            return creature;
        }
        return null;
    }

}