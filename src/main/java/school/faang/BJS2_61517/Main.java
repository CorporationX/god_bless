package school.faang.BJS2_61517;

public class Main {

    private static final int MAX_AMOUNT_PLAYERS_IN_BATTLE = 1;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_AMOUNT_PLAYERS_IN_BATTLE);
        Player alex = new Player("Alex");
        Player stefan  = new Player("Stefan");

        Thread alexThread = new Thread(() -> alex.doBattle(boss));
        Thread stefanThread = new Thread(() -> stefan.doBattle(boss));

        alexThread.start();
        stefanThread.start();
    }
}
