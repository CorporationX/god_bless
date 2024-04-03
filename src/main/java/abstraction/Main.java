package abstraction;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Legolas");
        Character warrior = new Warrior("Aragorn");

        archer.attack(warrior);
        System.out.println("");
        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
    }
}
