package school.faang.AbstractionAbstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior one");
        Archer archer = new Archer("Archer one");

        warrior.attack(archer);
        System.out.println("Health of: " + archer.getName() + ":" + archer.getHealth());
        archer.attack(warrior);
        System.out.println("Health of: " + warrior.getName() + ":" + warrior.getHealth());
    }
}
