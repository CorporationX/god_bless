package school.faang;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("name");
        Character archer = new Archer("name");

        warrior.attack(archer);
    }
}
