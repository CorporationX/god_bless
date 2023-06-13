package faang.school.godbless.abstractTask;

public class Main {
    static Warrior warrior = new Warrior("Pavel");
    static Archer archer = new Archer("Vlad");

    public static void main(String[] args) {
        warrior.attack(archer);
        warrior.attack(archer);
    }
}
