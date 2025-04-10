package school.faang.bjs2_68140;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Legion");
        Warrior warrior = new Warrior("Bjorn");

        System.out.println("Initial state of characters:");
        System.out.println(archer);
        System.out.println(warrior);

        System.out.println("\nArcher attacks warrior");
        archer.attack(warrior);
        System.out.println(warrior);

        System.out.println("\nWarrior attacks archer");
        warrior.attack(archer);
        System.out.println(archer);

        System.out.println("\nArcher attacks warrior");
        archer.attack(warrior);
        System.out.println(warrior);

        System.out.println("\nWarrior attacks archer");
        warrior.attack(archer);
        System.out.println(archer);
    }
}
