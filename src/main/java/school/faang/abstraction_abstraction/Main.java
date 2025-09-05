package school.faang.abstraction_abstraction;

public class Main {
    static String warriorName = "Арагон";
    static String archerName = "Ладрогон";

    static Warrior warrior = new Warrior(warriorName);
    static Archer archer = new Archer(archerName);

    public static void main(String[] args) {
        System.out.println("\n=== Тесты: Абстракция, абстракция! ===\n");

        System.out.println("Воин: " + warrior.getName() + "\n" + "Здоровье: " + warrior.getHealth() + "\n");
        System.out.println("Лучник: " + archer.getName() + "\n" + "Здоровье: " + archer.getHealth() + "\n");

        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("Воин: " + warrior.getName() + "\n" + "Здоровье: " + warrior.getHealth() + "\n");
        System.out.println("Лучник: " + archer.getName() + "\n" + "Здоровье: " + archer.getHealth() + "\n");

        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }

        System.out.println("Лучник: " + archer.getName() + "\n" + "Здоровье: " + archer.getHealth() + "\n");

        System.out.println("=== Конец тестов ===");
    }
}
