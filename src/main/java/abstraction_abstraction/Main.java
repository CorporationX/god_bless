package abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("German");
        Warrior warrior = new Warrior("Lida");

        archer.attack(warrior);

        System.out.println(warrior.health);
    }
}
