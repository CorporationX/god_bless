package school.faang.task_56456;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        System.out.println("Warrior's health: " + warrior.getHealth());
        Character archer = new Archer("Archer");
        System.out.println("Archer's health: " + archer.getHealth());

        warrior.attack(archer);
        System.out.println("Archer's health: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println("Warrior's health: " + warrior.getHealth());

        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
            System.out.println("Archer's health: " + archer.getHealth());
        }
    }
}
