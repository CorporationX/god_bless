package taskAbstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        archer.attack(warrior);
        warrior.attack(archer);
        warrior.attack(archer);

        Character.checkHealth(warrior);
        Character.checkHealth(archer);
    }
}
