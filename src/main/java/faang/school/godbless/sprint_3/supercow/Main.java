package faang.school.godbless.sprint_3.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Player player3 = new Player("test3");
        Player player4 = new Player("test4");

        Thread thread1 = new Thread(() -> player1.startBattle(boss));
        Thread thread2 = new Thread(() -> player2.startBattle(boss));
        Thread thread3 = new Thread(() -> player3.startBattle(boss));
        Thread thread4 = new Thread(() -> player4.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}