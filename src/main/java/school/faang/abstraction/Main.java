package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");

        System.out.println(warrior.getName() + " attacks " + archer.getName());
        warrior.attack(archer);
        System.out.println(archer.getName() + "'s health: " + archer.getHealth());

        System.out.println(archer.getName() + " attacks " + warrior.getName());
        archer.attack(warrior);
        System.out.println(warrior.getName() + "'s health: " + warrior.getHealth());
    }
}