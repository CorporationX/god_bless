package faang.school.godbless.Abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Dwarck");
        Archer archer = new Archer("Odin");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
