package school.faang.bjs2_85555;

import java.util.Random;

public class Main {
    private static final int CRITICAL_HIT_BONUS = 10;
    private static final int MAX_RANDOM_DAMAGE = 5;
    private static final int HEALTH_THRESHOLD = 0;

    public static void main(String[] args) {
        System.out.println("Начало битвы в долине героев");

        Character warrior = new Warrior("Олег железный кулак");
        Character archer = new Archer("Петя соколинный глаз");

        System.out.println();
        System.out.println("На арену выходят бойцы: ");
        System.out.println(warrior.toString());
        System.out.println(archer.toString());
        System.out.println();
        System.out.println("Первая атака:");

        warrior.attack(archer);

        System.out.println("Воин " + warrior.getName() + ", ударом меча атакует " + archer.getName());
        System.out.println("У " + archer.getName() + " осталось " + archer.getHealth() + " жизней");
        System.out.println();
        System.out.println("Вторая атака:");

        warrior.attack(archer);

        System.out.println(warrior.getName() + " снова бьет " + archer.getName() + " с силой " + warrior.getStrength() + " единиц!");
        System.out.println("У " + archer.getName() + " осталось " + archer.getHealth() + " жизней");
        System.out.println(archer.getName() + ": 'Эй, Егор, помоги! Этот варвар слишком силён!'");
        System.out.println();

        Character archer2 = new Archer("Егор смертоносная стрела");

        System.out.println("На арене неожиданный разворот событий, появляется ещё один лучник: ");
        System.out.println(archer2.toString());
        System.out.println();
        System.out.println("Два лучника против одного война:");
        System.out.println(archer2.getName() + ": 'Я с тобой, Петя! За мной!'\n");

        archer.attack(warrior);

        System.out.println(archer.getName() + " выпускает стрелу в " + warrior.getName() + "!");
        System.out.println("У " + warrior.getName() + " осталось " + warrior.getHealth() + " жизней");

        archer2.attack(warrior);

        System.out.println(archer2.getName() + " точным выстрелом попадает в " + warrior.getName() + "!");
        System.out.println("У " + warrior.getName() + " осталось " + warrior.getHealth() + " жизней");

        archer.attack(warrior);

        System.out.println(archer.getName() + ": 'Еще одна стрела для тебя, варвар!'");
        System.out.println("У " + warrior.getName() + " осталось " + warrior.getHealth() + " жизней\n");

        System.out.println("Финальная атака:");

        Random random = new Random();
        boolean criticalHit = random.nextBoolean();
        int finalDamage;

        if (criticalHit) {
            finalDamage = warrior.getHealth() + CRITICAL_HIT_BONUS;
            System.out.println(archer2.getName() + " прицеливается... чувствуется мощная энергия!");
            System.out.println("Это критический выстрел!");
        } else {
            finalDamage = archer2.getAgility() + random.nextInt(MAX_RANDOM_DAMAGE);
            System.out.println(archer2.getName() + " прицеливается и выпускает стрелу!");
        }

        warrior.reduceHealth(finalDamage);

        if (warrior.getHealth() <= HEALTH_THRESHOLD) {
            System.out.println(warrior.getName() + " падает на колени и терпит поражение!");
            System.out.println(archer.getName() + " и " + archer2.getName() + " побеждают в этой битве!");

            if (criticalHit) {
                System.out.println("Решающая стрела оказалась смертельной!");
            }

        } else {
            System.out.println(warrior.getName() + " выстоял с " + warrior.getHealth() + " HP и готов к контратаке!");
            System.out.println(archer2.getName() + " промахнулся в решающий момент!");
        }

        System.out.println();
        System.out.println("Битва завершена");
    }
}
