package school.faang.supercow;

public class SupercowBattleTest {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player[] players = {
                new Player("Игрок 1", boss),
                new Player("Игрок 2", boss),
                new Player("Игрок 3", boss),
                new Player("Игрок 4", boss),
                new Player("Игрок 5", boss),
                new Player("Игрок 6", boss),
        };

        for (Player player : players) {
            new Thread(player).start();
        }
    }
}
