package heroesOfMightAndMagic;

import java.util.Map;

public class Battlefield {

    public static void main(String[] args) {
        Hero hero1 = new Hero("Nick", "Mountain");
        Hero hero2 = new Hero("Paul", "River");

        hero1.addCreature(new Angel(), 23);
        hero1.addCreature(new Griffin(), 6);
        hero1.addCreature(new Pikeman(), 7);
        hero1.addCreature(new Swordman(), 10);

        hero2.addCreature(new Pikeman(), 50);
        hero2.addCreature(new Swordman(), 50);

        printArmyOfHero(hero1);
        printArmyOfHero(hero2);

        System.out.println("Победитель сражения: " + battle(hero1, hero2).getName());
    }

    public static Hero battle(Hero hero1, Hero hero2) {
        int i = 0;
        Hero winner;
        System.out.println("Битва началась!");

        while ((!hero1.getArmy().isEmpty()) && (!hero2.getArmy().isEmpty())) {

            System.out.println("Ход первого игрока " + hero1.getName() + "\n");
            playersMove(hero1, hero2);
            System.out.println("Ход второго игрока " + hero2.getName() + "\n");
            playersMove(hero2, hero1);

            i++;
            System.out.println("Результаты раунда '" + i + "'\n");
            printArmyOfHero(hero1);
            printArmyOfHero(hero2);
        }
        if (hero1.getArmy().isEmpty()) {
            winner = hero2;
        } else {
            winner = hero1;
        }
        return winner;
    }

    public static int countQuantityAfterAttack(Map.Entry<Creature, Integer> attack, Map.Entry<Creature, Integer> protect) {
        int hp;
        int damage = attack.getKey().getDamage() * attack.getValue();

        if (protect.getKey().getHpAfterAttack() != 0) {
            hp = protect.getKey().getAttack() * (protect.getValue() - 1) + protect.getKey().getHpAfterAttack();
        } else {
            hp = protect.getKey().getHealth() * protect.getValue();
        }

        hp -= damage;
        if (hp % protect.getKey().getHealth() == 0) {
            return hp / protect.getKey().getHealth();
        } else {
            protect.getKey().setHpAfterAttack(hp % protect.getKey().getHealth());
            return hp / protect.getKey().getHealth() + 1;
        }
    }

    public static void printArmyOfHero(Hero hero) {
        System.out.println("Iмя героя: " + hero.getName());
        if (hero.getArmy().isEmpty()) {
            System.out.println("Все существа мертвы!\n");
        } else {
            for (Map.Entry<Creature, Integer> entry : hero.getArmy().entrySet()) {
                System.out.println("Существо: " + entry.getKey().getName() +
                        "\nКоличество: " + entry.getValue() + "\n");
            }
        }
    }

    private static void playersMove(Hero hero1, Hero hero2) {
        for (Map.Entry<Creature, Integer> entry1 : hero1.getArmy().entrySet()) {
            for (Map.Entry<Creature, Integer> entry2 : hero2.getArmy().entrySet()) {
                int diedCreature = entry2.getValue() - countQuantityAfterAttack(entry1, entry2);
                hero2.removeCreature(entry2.getKey(), diedCreature);
                break;
            }
        }
    }
}
