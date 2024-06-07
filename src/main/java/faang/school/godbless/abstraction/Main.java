package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Naruto");
        Archer archer = new Archer("Sukuna");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
