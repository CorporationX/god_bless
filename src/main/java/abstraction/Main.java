package abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Kratos");
        Warrior warrior2 = new Warrior("Atrey");
        System.out.println(warrior1);
        System.out.println(warrior2);

        Archer archer1 = new Archer("Thomas");
        Archer archer2 = new Archer("Lambert");
        System.out.println(archer1);
        System.out.println(archer2);

        for (int i = 0; i < 10; i++) {
            warrior1.attack(archer1);
        }
        System.out.println("----------------------------------");
        for (int i = 0; i < 10; i++) {
            archer2.attack(warrior2);
        }
    }
}
