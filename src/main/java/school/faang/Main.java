package school.faang;

public class Main {
    public static void main(String[] args) {
        Character robin = new Archer("Robin");
        Character leonid = new Warrior("Leonid");

        System.out.println(robin.getHealth());
        leonid.attack(robin);
        System.out.println("Leonid attacked Robin");
        System.out.println(robin.getHealth());
    }
}
