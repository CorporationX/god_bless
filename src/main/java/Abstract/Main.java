package Abstract;

public class Main {
    public static void main(String[] args) {
        Character berserk = new Warrior("Odin");
        Character john = new Archer("John");

        berserk.attack(john);
        john.attack(berserk);
    }
}
