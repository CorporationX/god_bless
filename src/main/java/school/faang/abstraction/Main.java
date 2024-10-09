package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Artur");
        Archer archer = new Archer("Gilgamesh");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
