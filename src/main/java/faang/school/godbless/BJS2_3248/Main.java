package faang.school.godbless.BJS2_3248;

public class Main {
    private static final int MAX_PLAYERS = 10;
    private static final int ALL_PLAYERS = 100;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        for (int i = 0; i < ALL_PLAYERS; ++i) {
            int playerId = i;
            new Thread(() -> new Player(String.valueOf(playerId)).startBattle(boss)).start();
        }
    }
}
