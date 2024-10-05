package school.faang.Abstraction;

public class Main {
    public static void main(String[] args) {
        Character robin = new Archer("Robin", 3, 10, 5);
        Character leonid = new Warrior("Leonid", 10, 5, 3);

        System.out.println("Robin's health: " + robin.getHealth());
        leonid.attack(robin);
        System.out.println("Leonid attacked Robin.");
        System.out.println("Robin's health: " + robin.getHealth());
    }
}
