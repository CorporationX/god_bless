package school.faang;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warior");
        Archer archer = new Archer("Archer");
        System.out.println("Warrior: " + warrior + " attacked " + " Archer: " + archer);
        warrior.attack(archer);
        System.out.println("Archer: " + archer + " attacked " + " Warrior: " + warrior);
        archer.attack(warrior);

    }
}
