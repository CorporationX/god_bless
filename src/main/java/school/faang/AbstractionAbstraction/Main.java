package school.faang.AbstractionAbstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior one", 10, 5, 3);
        Archer archer = new Archer("Archer one", 3, 10, 5);

        warrior.attack(archer);
        System.out.println("Health of: " + archer.getName() + ":" + archer.getHealth());
        archer.attack(warrior);
        System.out.println("Health of: " + warrior.getName() + ":" + warrior.getHealth());
    }
}
