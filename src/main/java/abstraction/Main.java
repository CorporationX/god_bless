package abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Tom", 10, 5, 3);
        Archer archer = new Archer("Bill", 3, 10, 5);
        warrior.attack(archer);
        int health = archer.health;
        System.out.println(health);
    }
}
