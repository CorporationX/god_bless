package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Legolas");
        Warrior warrior = new Warrior("Aragorn");
        System.out.println("Aragorn health " + warrior.health);
        System.out.println("Legolas health " + archer.health);
        System.out.println("Legolas attack Aragorn");
        archer.attack(warrior);
        System.out.println("Aragorn health " + warrior.health);
        warrior.attack(archer);
        System.out.println("Legolas health " + archer.health);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println("Aragorn health " + warrior.health);
        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
        System.out.println("Legolas health " + archer.health);
    }
}
