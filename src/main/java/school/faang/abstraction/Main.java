package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        testNullName();
        testAttack();
        testDeathHero();
    }

    public static void testNullName() {
        try {
            new Warrior(null);
            System.out.println("ПРОВЕРКА НА NULL: ТЕСТ НЕ ПРОЙДЕН");
        } catch (NullPointerException e) {
            System.out.println("ПРОВЕРКА НА NULL: ТЕСТ ПРОЙДЕН " + e.getMessage());
        }
    }

    public static void testAttack() {
        Character artur = new Warrior("Artur");
        Character egor = new Archer("Egor");

        artur.attack(egor);
        egor.attack(artur);

        if (egor.getHealth() == (Character.MAX_XP - Warrior.STRENGTH_FOR_WARRIOR)
                && artur.getHealth() == Character.MAX_XP - Archer.AGILITY_FOR_ARCHER) {
            System.out.println("ПРОВЕРКА МЕТОДА АТАКА: ТЕСТ ПРОЙДЕН");
        } else {
            System.out.println("ПРОВЕРКА МЕТОДА АТАКА: ТЕСТ НЕ ПРОЙДЕН");
        }
    }

    public static void testDeathHero() {
        Character oleg = new Warrior("Oleg");
        Character lord = new Archer("Lord");

        try {
            for (int i = 0; i < 11; i++) {
                oleg.attack(lord);
            }
            System.out.println("ПРОВЕРКА СМЕРТИ ГЕРОЯ: ТЕСТ НЕ ПРОЙДЕН");
        } catch (NullPointerException e) {
            System.out.println("ПРОВЕРКА СМЕРТИ ГЕРОЯ: ТЕСТ ПРОЙДЕН " + e.getMessage());
        }
    }
}