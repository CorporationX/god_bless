package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Varya");
        Archer archer = new Archer("Vlad");

        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        archer.attack(warrior);
    }
}