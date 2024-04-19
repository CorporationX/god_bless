package faang.school.godbless.Supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");

        Thread playerThread1 = new Thread(() -> player1.startBattle(boss));
        Thread playerThread2 = new Thread(() -> player2.startBattle(boss));
        Thread playerThread3 = new Thread(() -> player3.startBattle(boss));
        Thread playerThread4 = new Thread(() -> player4.startBattle(boss));

        playerThread1.start();
        playerThread2.start();
        playerThread3.start();
        playerThread4.start();
    }
}