package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        try {
            new Battle(new Warrior("King"), new Archer("Lord"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

}
