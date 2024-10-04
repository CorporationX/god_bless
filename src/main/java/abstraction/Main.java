package abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Tank");
        Character archer = new Archer("DamageDealer");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("Archer health: " + archer.getHealth());
        System.out.println("Warrior health: " + warrior.getHealth());
    }
}
