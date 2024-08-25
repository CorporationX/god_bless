package faang.school.godbless.BJS2_24371;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("qwerte");
        Player player2 = new Player("werrs");
        Player player3 = new Player("sad3s");
        Player player4 = new Player("sferrw2");

        Thread t1 = new Thread(() -> player1.startBattle(boss));
        Thread t2 = new Thread(() -> player2.startBattle(boss));
        Thread t3 = new Thread(() -> player3.startBattle(boss));
        Thread t4 = new Thread(() -> player4.startBattle(boss));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
