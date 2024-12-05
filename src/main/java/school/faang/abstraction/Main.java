package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Фёдор");
        Warrior warrior = new Warrior("Володя");

        for (int i = 0; i < 10; i++) {
            archer.attack(warrior);
            System.out.println("У Володи осталось " + warrior.health + " хп");
            warrior.attack(archer);
            System.out.println("У Фёдора осталось " + archer.health + " хп");
        }

    }
}