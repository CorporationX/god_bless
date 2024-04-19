package faang.school.godbless.bjs2_5619;

public class Main {

    private static final int MAX_PLAYERS = 3;
    private static final int TIMEOUT = 1000;

    public static void main(String[] args) throws InterruptedException {

        Boss boss = new Boss("Monster", MAX_PLAYERS);

        Player ivan = new Player("Ivan");
        Player petr = new Player("Petr");
        Player sveta = new Player("Sveta");
        Player katya = new Player("Katya");

        Thread threadIvan = new Thread(() -> ivan.startBattle(boss));
        Thread threadPetr = new Thread(() -> petr.startBattle(boss));
        Thread threadSveta = new Thread(() -> sveta.startBattle(boss));
        Thread threadKatya = new Thread(() -> katya.startBattle(boss));

        threadIvan.start();
        Thread.sleep(TIMEOUT);
        threadPetr.start();
        Thread.sleep(TIMEOUT);
        threadSveta.start();
        Thread.sleep(TIMEOUT);
        threadKatya.start();
    }
}
