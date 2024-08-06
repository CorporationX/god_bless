package faang.school.godbless;

import java.util.Random;

public class Battlefield {

    public static Random RANDOM = new Random();
    public static int MAX_CREATURES = 20;
    public static int MAX_EXPERIENCE = 700;
    public static String[] FRACTIONS = new String[]{"Warrior", "Healer"};

    public static Pikeman PIKEMAN = new Pikeman();
    public static Griffin GRIFFIN = new Griffin();
    public static Swordman SWORDMAN = new Swordman();
    public static Angel ANGEL = new Angel();


    public static void main(String[] args) {
        Hero hero1 = initHero("Fred");
        Hero hero2 = initHero("Wolf");
        battle(hero1, hero2);
    }

    /*
    [V] - удачное собыьте
    [X] - неудачное событие
    [=] - результат
     */
    public static void battle(Hero hero1, Hero hero2) {
        int countWinHero1 = 0;
        int countWinHero2 = 0;
        int countDraw = 0;
        int round = 1;

        while (countWinHero1 < 1 && countWinHero2 < 1) {
            System.out.println("\n< Битва: " + round + " >");
            round++;

            System.out.println("\nХод " + hero1.getName());
            initArmy(hero1);

            System.out.println("\nХод " + hero2.getName());
            initArmy(hero2);

            int damageHero1 = hero1.getAllDamageArmy();
            System.out.println("[=]Атака героя " + hero1.getName() + " :" + damageHero1);
            int damageHero2 = hero2.getAllDamageArmy();
            System.out.println("[=]Атака героя " + hero2.getName() + " :" + damageHero2);

            int defenseHero1 = hero1.getAllArmourArmy();
            System.out.println("[=]Защита героя " + hero1.getName() + " : " + defenseHero1);
            int defenseHero2 = hero2.getAllArmourArmy();
            System.out.println("[=]Защита героя " + hero2.getName() + " : " + defenseHero2);

            int finalDamageHero1 = Math.max(damageHero1 - defenseHero2, 0);
            System.out.println("\n[=]Урон героя " + hero1.getName() + " : " + finalDamageHero1);
            int finalDamageHero2 = Math.max(damageHero2 - defenseHero1, 0);
            System.out.println("[=]Урон героя " + hero2.getName() + " : " + finalDamageHero2);

            if (finalDamageHero1 > finalDamageHero2) {
                System.out.println("\n< Победил " + hero1.getName() + " >");
                countWinHero1++;
            } else if (finalDamageHero2 > finalDamageHero1) {
                System.out.println("\n< Победил " + hero2.getName() + " >");
                countWinHero2++;
            } else {
                System.out.println("\n< Ничья >");
                countDraw++;
            }
        }
        System.out.println("\nЧисло побед героя " + hero1.getName() + " : " + countWinHero1);
        System.out.println("Число побед героя " + hero2.getName() + " : " + countWinHero2);
        System.out.println("Число ничьей: " + countDraw);
        if (countWinHero1 > countWinHero2) {
            System.out.println("\n< В войне победил герой " + hero1.getName() + " >");
        } else {
            System.out.println("\n< В войне победил герой " + hero2.getName() + " >");
        }
    }

    public static void initArmy(Hero hero) {
        hero.addCreatureToArmy(PIKEMAN, RANDOM.nextInt(MAX_CREATURES) + 1);
        hero.addCreatureToArmy(GRIFFIN, RANDOM.nextInt(MAX_CREATURES) + 1);
        hero.addCreatureToArmy(SWORDMAN, RANDOM.nextInt(MAX_CREATURES) + 1);
        hero.addCreatureToArmy(ANGEL, RANDOM.nextInt(MAX_CREATURES) + 1);
        System.out.println(hero.getAllArmy());
    }

    public static Hero initHero(String name) {
        int experience = RANDOM.nextInt(MAX_EXPERIENCE) + 1;
        int level = experience / 100;
        String fraction = FRACTIONS[RANDOM.nextInt(FRACTIONS.length)];
        Hero newHero = new Hero(name, fraction, experience, level);
        System.out.println("Герой " + newHero.getName() + " создан: " + newHero.toString());
        return newHero;
    }
}

