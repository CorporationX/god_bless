package faang.school.javacore.abstraction;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer.health);
        System.out.println(warrior.health);

    }
}
