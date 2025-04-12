package BJS2_68191;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer") {
            @Override
            public void attak(Character opponent) {
            }
        };
        Character warrior = new Warrior("Warrior") {
            @Override
            public void attak(Character opponent) {
            }
        };
        System.out.println("Warrior health: " + warrior.getHealth());

        ((Archer) archer).attack(warrior);
        System.out.println("Warrior health: " + warrior.getHealth());

        for (int i = 0; i < 12; i++) {
            ((Warrior) warrior).attack(archer);
            System.out.println("Archer health: " + archer.getHealth());
        }
    }
}
