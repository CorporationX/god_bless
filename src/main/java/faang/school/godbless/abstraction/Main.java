package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("John");
        Archer archer = new Archer("Jane");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());
    }
}
