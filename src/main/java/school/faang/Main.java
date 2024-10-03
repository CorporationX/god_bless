package school.faang;


public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        System.out.println("Health of warrior: " + warrior.health);

        Archer archer = new Archer("Archer");
        System.out.println("Archer health: " + archer.health);

        // Case: warrior attacks archer
        warrior.attack(archer);
        System.out.println("Archer health: " + archer.health);

        // Case: archer attacks warrior
        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.health);
    }
}
