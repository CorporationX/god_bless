package school.faang.task_49800;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();

        Player player1 = new Player("Ilon");
        Player player2 = new Player("Stif");
        Player player3 = new Player("Alex");
        Thread thread1 = new Thread(() -> player1.startBattle(boss));
        Thread thread2 = new Thread(() -> player2.startBattle(boss));
        Thread thread3 = new Thread(() -> player3.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
