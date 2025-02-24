package school.faang.taskabstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
    }
}
