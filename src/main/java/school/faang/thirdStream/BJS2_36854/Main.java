package school.faang.thirdStream.BJS2_36854;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Тамуз");
        Player player2 = new Player("Ланселот");
        Player player3 = new Player("Клинт");

        Thread thread1 = new Thread(() -> player1.startBattle(boss));

        Thread thread2 = new Thread(() -> player2.startBattle(boss));

        Thread thread3 = new Thread(() -> player3.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}