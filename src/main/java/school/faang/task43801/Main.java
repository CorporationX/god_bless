package school.faang.task43801;

public class Main {
    public static void main(String[] args) {
        try {
            Archer archer = new Archer(10, 15, 2, "Леголас");
            Warrior warrior = new Warrior(10, 8, 10, "Арагорн");

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
