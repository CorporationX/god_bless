package school.faang.bjs2_86440;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Zombies with a sword");
        Archer archer = new Archer("Skeleton on the chicken");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("\nAfter attack: ");
        System.out.println(warrior.getName() + ": " + warrior.getHealth());
        System.out.println(archer.getName() + ": " + archer.getHealth());
    }
}