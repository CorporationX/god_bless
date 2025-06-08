package school.faang.bjs2_79229;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer", 5, 5, 5);

        System.out.printf("%s: [%s]%n", warrior.getClass().getSimpleName(), warrior);
        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }
    }
}