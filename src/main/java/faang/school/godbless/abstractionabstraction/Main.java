package faang.school.godbless.abstractionabstraction;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Aragorn");
        Character archer = new Archer("Legolas");

        System.out.printf("%s's health: %d%n", warrior.name, warrior.health);
        System.out.printf("%s's health: %d%n", archer.name, archer.health);

        System.out.printf("%s is attacking %s%n", warrior.name, archer.name);
        warrior.attack(archer);
        System.out.printf("%s is attacking %s%n", archer.name, warrior.name);
        archer.attack(warrior);

        System.out.printf("%s's health: %d%n", warrior.name, warrior.health);
        System.out.printf("%s's health: %d%n", archer.name, archer.health);
    }
}