package school.faang.bjs2_82164;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        Boss boss = new Boss(2, "FinalBoss");

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");

        Thread thread1 = new Thread(() -> player1.doBattle(boss), "Player1");
        Thread thread2 = new Thread(() -> player2.doBattle(boss), "Player2");
        Thread thread3 = new Thread(() -> player3.doBattle(boss), "Player3");
        Thread thread4 = new Thread(() -> player4.doBattle(boss), "Player4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
