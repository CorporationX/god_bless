package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer1");
        Character warrior = new Warrior("Warrior1");
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println("Archer attacks " + warrior);
        warrior.attack(archer);
        System.out.println("Warrior attacks " + archer);

    }
}
