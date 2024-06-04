package faang.school.godbless.abstraction;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer("archer");
        Warrior warrior = new Warrior("warrior");

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println(archer);
        System.out.println(warrior);
    }
}
