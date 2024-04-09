package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
