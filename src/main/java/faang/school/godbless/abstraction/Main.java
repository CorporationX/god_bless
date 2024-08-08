package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Varya", 10, 5, 3);
        Archer archer = new Archer("Vlad", 3, 10, 5);

        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
