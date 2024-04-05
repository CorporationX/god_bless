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
            for (Map.Entry<String, Creature> entry1 : hero1.getArmy().entrySet()) {
                for (Map.Entry<String, Creature> entry2 : hero2.getArmy().entrySet()) {
                    int diedCreature = entry2.getValue().getQuantity() - countQuantityAfterAttack(entry1.getValue(), entry2.getValue());
                    hero2.removeCreature(entry2.getValue(), diedCreature);
                    break;
                }
            }
            System.out.println("Ход второго игрока " + hero2.getName() + "\n");
            for (Map.Entry<String, Creature> entry2 : hero2.getArmy().entrySet()) {
                for (Map.Entry<String, Creature> entry1 : hero1.getArmy().entrySet()) {
                    int diedCreature = entry1.getValue().getQuantity() - countQuantityAfterAttack(entry2.getValue(), entry1.getValue());
                    hero1.removeCreature(entry1.getValue(), diedCreature);
                    break;
                }
            }
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

    public static int countQuantityAfterAttack(Creature attack, Creature protect) {
        int hp;
        int damage = attack.getAttack() * attack.getQuantity();

        if (protect.getHpAfterAttack() != 0) {
            hp = protect.getHealth() * (protect.getQuantity() - 1) + protect.getHpAfterAttack();
        } else {
            hp = protect.getHealth() * protect.getQuantity();
        }

        hp -= damage;
        if (hp % protect.getHealth() == 0) {
            return hp / protect.getHealth();
        } else {
            protect.setHpAfterAttack(hp % protect.getHealth());
            return hp / protect.getHealth() + 1;
        }
    }

    public static void printArmyOfHero(Hero hero) {
        System.out.println("Iмя героя: " + hero.getName());
        if (hero.getArmy().isEmpty()) {
            System.out.println("Все существа мертвы!\n");
        } else {
            for (Map.Entry<String, Creature> entry : hero.getArmy().entrySet()) {
                System.out.println("Существо: " + entry.getValue().getName() +
                        "\nКоличество: " + entry.getValue().getQuantity() + "\n");
            }
        }
    }
}
