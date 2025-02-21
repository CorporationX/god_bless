package school.faang.task_58525;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Mike");
        Character archer = new Archer("Gon");
        try {
            for (int i = 0; i < 11; i++) {
                archer.attack(warrior);
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
