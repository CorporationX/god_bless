package school.faang.bjs2_79166;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("John");
        Character archer = new Archer("Jane");

        while (true) {
            archer.attack(warrior);
            if (warrior.health == 0) {
                break;
            }

            warrior.attack(archer);
            if (archer.health == 0) {
                break;
            }
        }
    }
}
