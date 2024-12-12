package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer1");
        Character warrior = new Warrior("Warrior1");
        Character warrior10 = new Warrior("Warrior10", 4, 40, 5);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior10);
        archer.attack(warrior10);
        archer.attack(warrior10);

        System.out.println("Archer attacks " + warrior10);
        warrior.attack(archer);
        System.out.println("Warrior attacks " + archer);

    }
}
