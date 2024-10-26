package supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");

        Thread firstPlayerThread = new Thread(() -> player1.startBattle(boss));
        Thread secondPlayerThread = new Thread(() -> player2.startBattle(boss));
        Thread thirdPlayerThread = new Thread(() -> player3.startBattle(boss));

        firstPlayerThread.start();
        secondPlayerThread.start();
        thirdPlayerThread.start();
    }
}
