package Abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("John");
        Character archer = new Archer("Bob");

        System.out.printf("Warrior's health: %d%n", warrior.getHealth());
        System.out.printf("Archer's health: %d%n", archer.getHealth());

        System.out.printf("%s is attacking %s%n", warrior.getName(), archer.getName());
        warrior.attack(archer);
        System.out.printf("%s is attacking %s%n", warrior.getName(), archer.getName());
        warrior.attack(archer);

        System.out.printf("%s is attacking %s%n", archer.getName(), warrior.getName());
        archer.attack(warrior);


        System.out.printf("Warrior's health: %d%n", warrior.getHealth());
        System.out.printf("Archer's health: %d%n", archer.getHealth());




    }
}
