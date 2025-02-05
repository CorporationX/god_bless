package BJS2_56427;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());
    }
}
