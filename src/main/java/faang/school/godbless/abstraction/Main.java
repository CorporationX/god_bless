package faang.school.godbless.abstraction;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("warrior");
        Archer archer = new Archer("archer");
        archer.attack(warrior);
        warrior.attack(archer);
    }
}
