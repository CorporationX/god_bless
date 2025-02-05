package school.faang.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        try {
            Character warrior = new Warrior("one");
            Character archer = new Archer("two");
            for (int i = 0; i < 14; i++) {
                warrior.attack(archer);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
