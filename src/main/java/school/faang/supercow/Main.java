package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2); // Босс с максимум 2 игроками одновременно

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Player player4 = new Player("Игрок 4");

        Thread thread1 = new Thread(() -> player1.doBattle(boss));
        Thread thread2 = new Thread(() -> player2.doBattle(boss));
        Thread thread3 = new Thread(() -> player3.doBattle(boss));
        Thread thread4 = new Thread(() -> player4.doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
