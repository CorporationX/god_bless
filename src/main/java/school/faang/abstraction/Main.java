package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior aragorn = new Warrior("Aragorn");
        Archer legolas = new Archer("Legolas");

        aragorn.attack(legolas);
        legolas.attack(aragorn);
    }
}
