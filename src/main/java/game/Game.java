package game;

public class Game {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Sword");
        Archer archer = new Archer("Bow");

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            warrior.attack(archer);

            if (archer.getHealth() <= 0) {
                System.out.println("Warrior wins!");
            } else {
                archer.attack(warrior);

                if (warrior.getHealth() <= 0) {
                    System.out.println("Archer wins!");
                }
            }
        }
    }
}
