package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        testWarriorAttack();
        testArcherAttack();
        testHealthNeverBelowZero();
    }

    // Тест: атака Warrior уменьшает здоровье противника на значение силы (strength)
    private static void testWarriorAttack() {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");


        System.out.println("testWarriorAttack:");
        System.out.printf("Начальное здоровье Archer: %d\n", archer.getHealth());

        warrior.attack(archer); // Warrior наносит удар со значением силы = 10

        System.out.printf("Здоровье Archer после атаки: %d\n", archer.getHealth());
        int expectedHealth = 100 - warrior.getStrength();
        if (archer.getHealth() == expectedHealth) {
            System.out.printf("✅ Passed: здоровье уменьшилось на %d\n", warrior.getStrength());
        } else {
            System.out.printf("❌ Failed: ожидалось %d, а получено %d\n", expectedHealth, archer.getHealth());
        }
        System.out.println();
    }

    // Тест: атака Archer уменьшает здоровье противника на значение ловкости (agility)
    private static void testArcherAttack() {
        Archer archer = new Archer("Legolas");
        Warrior warrior = new Warrior("Conan");

        System.out.println("testArcherAttack:");
        System.out.printf("Начальное здоровье Warrior: %d\n", warrior.getHealth());

        archer.attack(warrior); // Archer наносит удар со значением ловкости = 10

        System.out.printf("Здоровье Warrior после атаки: %d\n", warrior.getHealth());
        int expectedHealth = 100 - archer.getAgility();
        if (warrior.getHealth() == expectedHealth) {
            System.out.printf("✅ Passed: здоровье уменьшилось на %d\n", archer.getAgility());
        } else {
            System.out.printf("❌ Failed: ожидалось %d, а получено %d\n", expectedHealth, warrior.getHealth());
        }
        System.out.println();
    }

    // Тест: здоровье противника не может стать меньше 0
    private static void testHealthNeverBelowZero() {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");

        System.out.println("testHealthNeverBelowZero:");
        // Атакуем Archer многократно, чтобы здоровье должно было упасть ниже 0
        for (int i = 0; i < 15; i++) {
            warrior.attack(archer);
        }
        System.out.printf("Здоровье Archer после 15 атак: %d\n", archer.getHealth());
        if (archer.getHealth() == 0) {
            System.out.println("✅ Passed: здоровье не ушло ниже 0");
        } else {
            System.out.printf("❌ Failed: здоровье оказалось %d\n", archer.getHealth());
        }
        System.out.println();
    }
}
