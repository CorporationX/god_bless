package school.faang.BJS2_68082;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Иван");
        Character archer = new Archer("Данила");
        printHealthStatus(warrior, archer);

        performAttacks(archer, warrior, 1);
        performAttacks(warrior, archer, 2);
        printHealthStatus(warrior, archer);

        performAttacks(warrior, archer, 15);
        printHealthStatus(warrior, archer);
    }

    private static void performAttacks(Character attacker, Character defender, int times) {
        for (int i = 0; i < times; i++) {
            attacker.attack(defender);
        }
    }

    private static void printHealthStatus(Character... characters) {
        for (Character character : characters) {
            System.out.printf("%s: здоровье %d%n", character.name, character.health);
        }
        System.out.println();
    }
}
