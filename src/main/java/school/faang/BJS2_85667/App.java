package school.faang.BJS2_85667;

public class App {

    public static void main(String[] args) {
        final Warrior warrior = new Warrior("Warusha");
        final Archer archer = new Archer("Luchusha");

        for (int i = 0; i < 3; i++) {
            warrior.attack(archer);
        }

        for (int i = 0; i < 2; i++) {
            archer.attack(warrior);
        }

        System.out.println(warrior);
        System.out.println(archer);
    }
}