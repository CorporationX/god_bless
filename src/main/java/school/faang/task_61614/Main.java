package school.faang.task_61614;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player[] players = new Player[6];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        for (Player player : players) {
            Thread thread = new Thread(() -> player.doBattle(boss));
            thread.start();
        }
    }
}
