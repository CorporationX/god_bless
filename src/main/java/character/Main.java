package character;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Harry");
        Character archer = new Archer("Drago");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
