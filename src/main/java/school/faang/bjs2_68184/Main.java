package school.faang.bjs2_68184;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior1");
        Archer archer = new Archer("Archer1");

        System.out.println("Before attack: ");
        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Archer health: " + archer.getHealth());

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("After attack: ");
        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Archer health: " + archer.getHealth());
    }
}