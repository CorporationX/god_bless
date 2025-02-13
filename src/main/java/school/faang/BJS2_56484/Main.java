package school.faang.BJS2_56484;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Gray");
        Character archer = new Archer("Oliver");

        for (int i = 0; i < 15; i++) {
            warrior.attack(archer);
        }
    }
}