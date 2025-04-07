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
        System.out.println("Начальное здоровье Archer: " + archer.getHealth());

        warrior.attack(archer); // Warrior наносит удар со значением силы = 10

        System.out.println("Здоровье Archer после атаки: " + archer.getHealth());
        int expectedHealth = 100 - warrior.getStrength();
        if (archer.getHealth() == expectedHealth) {
            System.out.println("✅ Passed: здоровье уменьшилось на " + warrior.getStrength());
        } else {
            System.out.println("❌ Failed: ожидалось " + expectedHealth + ", а получено " + archer.getHealth());
        }
        System.out.println();
    }

    // Тест: атака Archer уменьшает здоровье противника на значение ловкости (agility)
    private static void testArcherAttack() {
        Archer archer = new Archer("Legolas");
        Warrior warrior = new Warrior("Conan");

        System.out.println("testArcherAttack:");
        System.out.println("Начальное здоровье Warrior: " + warrior.getHealth());

        archer.attack(warrior); // Archer наносит удар со значением ловкости = 10

        System.out.println("Здоровье Warrior после атаки: " + warrior.getHealth());
        int expectedHealth = 100 - archer.getAgility();
        if (warrior.getHealth() == expectedHealth) {
            System.out.println("✅ Passed: здоровье уменьшилось на " + archer.getAgility());
        } else {
            System.out.println("❌ Failed: ожидалось " + expectedHealth + ", а получено " + warrior.getHealth());
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
        System.out.println("Здоровье Archer после 15 атак: " + archer.getHealth());
        if (archer.getHealth() == 0) {
            System.out.println("✅ Passed: здоровье не ушло ниже 0");
        } else {
            System.out.println("❌ Failed: здоровье оказалось " + archer.getHealth());
        }
        System.out.println();
    }
}
