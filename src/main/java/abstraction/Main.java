package abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        System.out.println(archer.health);

        archer.attack(warrior);
        System.out.println(warrior.health);
    }
}
