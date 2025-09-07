package school.faang.bjs2_85564;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");

        System.out.println(archer);
        warrior.attack(archer);
        System.out.println(archer);

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            warrior.attack(archer);
            System.out.println(archer);
            archer.attack(warrior);
            System.out.println(warrior);
        }

        battleResult(warrior, archer);
    }

    public static void battleResult(Character c1, Character c2) {
        if (c1.getHealth() <= 0 && c2.getHealth() <= 0) {
            System.out.println("Оба персонажа повержены друг другом");
        } else if (c1.getHealth() <= 0) {
            System.out.printf("%s повержен %s%n", c1.getName(), c2.getName());
        } else if (c2.getHealth() <= 0) {
            System.out.printf("%s повержен %s%n", c2.getName(), c1.getName());
        } else {
            System.out.println("Оба персонажа живы");
        }
    }
}
