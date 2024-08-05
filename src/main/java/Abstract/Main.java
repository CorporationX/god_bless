package Abstract;

public class Main {
    public static void main(String[] args) {
        Warrior berserk = new Warrior("Odin");
        Archer john = new Archer("John");


        berserk.atack(new Archer("Anton"));
        john.atack(new Warrior("Berserk"));





    }
}
