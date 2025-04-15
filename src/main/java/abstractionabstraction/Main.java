package abstractionabstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thorin");
        Archer archer = new Archer("Legolas");

        System.out.println("=== Тест 1: До атаки ===");
        System.out.println("Warrior: " + warrior.getHealth() + " HP");
        System.out.println("Archer: " + archer.getHealth() + " HP");

        warrior.attack(archer);

        System.out.println("=== После атаки Warrior -> Archer ===");
        System.out.println("Warrior: " + warrior.getHealth() + " HP");
        System.out.println("Archer: " + archer.getHealth() + " HP");

        archer.attack(warrior);

        System.out.println("=== После атаки Archer -> Warrior ===");
        System.out.println("Warrior: " + warrior.getHealth() + " HP");
        System.out.println("Archer: " + archer.getHealth() + " HP");

        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }

        System.out.println("=== Тест 3: Много атак ===");
        System.out.println("Archer: " + archer.getHealth() + " HP");
    }
}
