package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character enemy = new Warrior("Boss");
        Character player = new Archer("Player1");

        player.attack(enemy);
        enemy.attack(player);

    }
}
