package school.faang;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Gojo");
        Character archer = new Archer("Sukuna");

        System.out.printf("%s HP: %d%n", warrior.getName(), warrior.getHealth());
        System.out.printf("%s HP: %d%n", archer.getName(), archer.getHealth());

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.printf("%s HP: %d%n", warrior.getName(), warrior.getHealth());
        System.out.printf("%s HP: %d%n", archer.getName(), archer.getHealth());
    }
}