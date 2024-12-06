package school.faang.bjs243903;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer1");
        Character warrior = new Warrior("Warrior1");

        FightManager.fight(archer, warrior);
    }
}
