package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer");
        Character warrior = new Warrior("Warrior");

        System.out.println("Starting stats");
        System.out.println(archer);
        System.out.println(warrior + "\n");

        System.out.println("Archer attack Warrior");
        archer.attack(warrior);
        System.out.println("Archer: " + archer.getHp() + " HP");
        System.out.println("Warrior: " + warrior.getHp() + " HP\n");

        System.out.println("Warrior attack Archer");
        warrior.attack(archer);
        System.out.println("Archer: " + archer.getHp() + " HP");
        System.out.println("Warrior: " + warrior.getHp() + " HP\n");

        System.out.println("Both of them attack each other");
        archer.attack(warrior);
        warrior.attack(archer);
        System.out.println("Archer: " + archer.getHp() + " HP");
        System.out.println("Warrior: " + warrior.getHp() + " HP\n");
    }
}
