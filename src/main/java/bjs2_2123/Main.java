package bjs2_2123;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.health);
        System.out.println("Archer health: " + archer.health);
    }
}
