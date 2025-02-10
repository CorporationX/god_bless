package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior1");
        Archer archer = new Archer("Archer1");

        warrior.attack(archer);
        archer.attack(warrior);

        Warrior warrior1 = new Warrior("Warrior", 15, 10, 10);
        Archer archer1 = new Archer("Archer", 10, 17, 22);
        archer1.reduceHealth(98);
        warrior1.attack(archer1);
        warrior1.attack(warrior);

    }
}
