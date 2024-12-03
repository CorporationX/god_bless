package school.faang.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Conan");
        Character archer = new Archer("Legolas");

        warrior.attack(archer);
        warrior.attack(warrior);
    }
}
