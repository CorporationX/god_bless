package school.faang.task_49664;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");

        Runnable task1 = () -> player1.startBattle(boss);
        Runnable task2 = () -> player2.startBattle(boss);
        Runnable task3 = () -> player3.startBattle(boss);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
