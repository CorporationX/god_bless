package faang.school.javacore.abstraction;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer("");
        Warrior warrior = new Warrior("warrior");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer.health);
        System.out.println(archer.name);
        System.out.println(warrior.health);
        System.out.println(warrior.name);

    }
}
