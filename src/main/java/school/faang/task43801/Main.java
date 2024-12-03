package school.faang.task43801;

public class Main {
    public static void main(String[] args) {
        try {
            Character archer = new Archer("Леголас");
            Character warrior = new Warrior("Арагорн");

            for (int i = 0; i < 12; i++) {
                System.out.println(archer);
                System.out.println(warrior + "\n");

                archer.attack(warrior);
                warrior.attack(archer);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
