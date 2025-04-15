package BJS2_68191;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Character warrior = new Warrior("Warrior");
        System.out.println("Warrior health: " + warrior.getHealth());

        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.getHealth());

        for (int i = 0; i < 12; i++) {
            warrior.attack(archer);
            System.out.println("Archer health: " + archer.getHealth());
        }
    }
}