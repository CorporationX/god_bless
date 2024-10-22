package Abstract;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Tor");
        Archer archer = new Archer("Halk");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
