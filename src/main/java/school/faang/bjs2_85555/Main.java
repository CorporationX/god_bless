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

        System.out.println("Воин " + warrior.name + ", ударом меча атакует " + archer.name);
        System.out.println("У " + archer.name + " осталось " + archer.health + " жизней");
        System.out.println();
        System.out.println("Вторая атака:");

        warrior.attack(archer);

        System.out.println(warrior.name + " снова бьет " + archer.name + " с силой " + warrior.strength + " единиц!");
        System.out.println("У " + archer.name + " осталось " + archer.health + " жизней");
        System.out.println(archer.name + ": 'Эй, Егор, помоги! Этот варвар слишком силён!'");
        System.out.println();

        Character archer2 = new Archer("Егор смертоносная стрела");

        System.out.println("На арене неожиданный разворот событий, появляется ещё один лучник: ");
        System.out.println(archer2.toString());
        System.out.println();
        System.out.println("Два лучника против одного война:");
        System.out.println(archer2.name + ": 'Я с тобой, Петя! За мной!'\n");

        archer.attack(warrior);

        System.out.println(archer.name + " выпускает стрелу в " + warrior.name + "!");
        System.out.println("У " + warrior.name + " осталось " + warrior.health + " жизней");

        archer2.attack(warrior);

        System.out.println(archer2.name + " точным выстрелом попадает в " + warrior.name + "!");
        System.out.println("У " + warrior.name + " осталось " + warrior.health + " жизней");

        archer.attack(warrior);

        System.out.println(archer.name + ": 'Еще одна стрела для тебя, варвар!'");
        System.out.println("У " + warrior.name + " осталось " + warrior.health + " жизней\n");

        System.out.println("Финальная атака:");

        Random random = new Random();
        boolean criticalHit = random.nextBoolean();
        int finalDamage;

        if (criticalHit) {
            finalDamage = warrior.health + CRITICAL_HIT_BONUS;
            System.out.println(archer2.name + " прицеливается... чувствуется мощная энергия!");
            System.out.println("Это критический выстрел!");
        } else {
            finalDamage = archer2.agility + random.nextInt(MAX_RANDOM_DAMAGE);
            System.out.println(archer2.name + " прицеливается и выпускает стрелу!");
        }

        warrior.reduceHealth(finalDamage);

        if (warrior.health <= HEALTH_THRESHOLD) {
            System.out.println(warrior.name + " падает на колени и терпит поражение!");
            System.out.println(archer.name + " и " + archer2.name + " побеждают в этой битве!");

            if (criticalHit) {
                System.out.println("Решающая стрела оказалась смертельной!");
            }
        } else {
            System.out.println(warrior.name + " выстоял с " + warrior.health + " HP и готов к контратаке!");
            System.out.println(archer2.name + " промахнулся в решающий момент!");
        }

        System.out.println();
        System.out.println("Битва завершена");
    }
}
