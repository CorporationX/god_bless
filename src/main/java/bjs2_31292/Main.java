package bjs2_31292;

public class Main {
    public static void main(String[] args) {
        Character conan = new Warrior("Conan");
        Character robin = new Archer("Robin");

        while (conan.getHealth() > 0 && robin.getHealth() > 0) {
            if (Math.random() < 0.5) {
                conan.attack(robin);
                System.out.println("Conan attack, Robin`s health: " + robin.getHealth());
            } else {
                robin.attack(conan);
                System.out.println("Robin attack, Conan`s health: " + conan.getHealth());
            }
        }
    }
}
