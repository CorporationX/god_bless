package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Lapyx");
        Character archer = new Archer("Keks");

        warrior.attack(archer);
        System.out.println("Здоровье " + archer.getName() + ": " + archer.getHealth());

        archer.attack(warrior);
        System.out.println("Здоровье " + warrior.getName() + ": " + warrior.getHealth());
    }
}