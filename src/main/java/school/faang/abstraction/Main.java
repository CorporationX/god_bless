package school.faang.abstraction;

public class Main {

    public static void main(String[] args) {
        Warrior tauren = new Warrior("Tauren");
        Warrior minotavr = new Warrior("Minotavr");

        tauren.attack(minotavr);
    }
}
