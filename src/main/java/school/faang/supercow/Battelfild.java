package school.faang.supercow;

public class Battelfild {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player[] players = {
                new Player("Alice", boss),
                new Player("Bob", boss),
                new Player("Charlie", boss),
                new Player("Dave", boss),
                new Player("Eve", boss)
        };

        for (Player p : players) {
            new Thread(p).start();
        }
    }
}
