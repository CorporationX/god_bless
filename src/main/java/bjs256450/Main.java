package bjs256450;

public class Main {
    public static void main(String[] args) {
        generateTestData();
    }

    private static void generateTestData() {
        Character warrior = new Warrior("Warrior");
        Character firstArcher = new Archer("FirstArcher");
        for (int i = 0; i < 10; i++) {
            warrior.attack(firstArcher);
            System.out.println("Strike " + i + " FirstArcher`s health: " + firstArcher.getHealth());
        }

        Character secondArcher = new Archer("SecondArcher");
        for (int i = 0; i < 10; i++) {
            secondArcher.attack(warrior);
            System.out.println("Strike " + i + " Warrior`s health: " + warrior.getHealth());
        }
    }
}