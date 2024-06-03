package BJS2_7720;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Jerry");
        Warrior warrior = new Warrior("Tom");

        warrior.attack(archer);
        warrior.attack(archer);

        archer.attack(warrior);

        System.out.println("Health warrior: " + warrior.getHEALTH());
        System.out.println("Health archer: " + archer.getHEALTH());
    }
}