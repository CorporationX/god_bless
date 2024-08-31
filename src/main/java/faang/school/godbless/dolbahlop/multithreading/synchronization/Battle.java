package faang.school.godbless.dolbahlop.multithreading.synchronization;

public class Battle {
    public static void main(String[] args) {
        Boss boss = new Boss(3, 0);
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        Player player4 = new Player("player4");
        Thread player1Thread = new Thread(() -> player1.startBattle(boss));
        Thread player2Thread = new Thread(() -> player2.startBattle(boss));
        Thread player3Thread = new Thread(() -> player3.startBattle(boss));
        Thread player4Thread = new Thread(() -> player4.startBattle(boss));
        player1Thread.start();
        player2Thread.start();
        player3Thread.start();
        player4Thread.start();
    }
}
