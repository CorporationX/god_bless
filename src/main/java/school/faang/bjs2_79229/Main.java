package school.faang.bjs2_79229;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}