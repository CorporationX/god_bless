package Abstract;

public class Main {
    public static void main(String[] args) {
        Warrior berserk = new Warrior("Odin");
        Archer john = new Archer("John");

        berserk.attack(john);
        john.attack(berserk);
    }
}
