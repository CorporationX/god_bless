package school.faang.sprint_1.task_43820;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Alex");
        Archer archer = new Archer("Bob");

        System.out.printf("Warrior health: %d%n", warrior.getHealth());
        System.out.printf("Archer health: %d%n", archer.getHealth());

        warrior.attack(archer);
        System.out.printf("Warrior health: %d%n", warrior.getHealth());
        System.out.printf("Archer health: %d%n", archer.getHealth());

        archer.attack(warrior);
        System.out.printf("Warrior health: %d%n", warrior.getHealth());
        System.out.printf("Archer health: %d%n", archer.getHealth());

    }
}
