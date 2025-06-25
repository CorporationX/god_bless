package school.faang.bjs2_82171;

public class BattleTest {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player[] players = {
                new Player("Alice"),
                new Player("Bob"),
                new Player("Charlie"),
                new Player("Diana")
        };

        for (Player player : players) {
            new Thread(() -> player.doBattle(boss)).start();
        }
    }
}
