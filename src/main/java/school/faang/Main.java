package school.faang;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);

    }
}