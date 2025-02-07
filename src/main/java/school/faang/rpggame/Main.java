package school.faang.rpggame;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Arch");
        Warrior warrior = new Warrior("Warrior");
        warrior.attack(archer);

    }
}
