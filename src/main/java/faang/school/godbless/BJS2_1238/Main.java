package faang.school.godbless.BJS2_1238;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");

        new Thread(() -> player1.startBattle(boss)).start();
        new Thread(() -> player2.startBattle(boss)).start();
        new Thread(() -> player3.startBattle(boss)).start();
        new Thread(() -> player4.startBattle(boss)).start();
    }
}