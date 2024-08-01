package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("first");
        Archer archer = new Archer("second");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
