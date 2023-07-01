package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5, 2);
        Player player1 = new Player("Viktor");
        Player player2 = new Player("Sergey");
        Player player3 = new Player("Andrew");

        Thread t1 = new Thread(() -> player1.startBattle(boss));
        Thread t2 = new Thread(() -> player2.startBattle(boss));
        Thread t3 = new Thread(() -> player3.startBattle(boss));

        t1.start();
        t2.start();
        t3.start();
    }
}
