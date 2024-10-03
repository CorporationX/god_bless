package abstractionAbstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Tank");
        Archer archer = new Archer("DamageDealer");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("Archer health: " + archer.getHealth());
        System.out.println("Warrior health: " + warrior.getHealth());
    }
}
