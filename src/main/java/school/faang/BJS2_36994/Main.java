package school.faang.BJS2_36994;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("User 1", boss);
        Player player2 = new Player("User 2", boss);
        Player player3 = new Player("User 3", boss);
        Player player4 = new Player("User 4", boss);
        Player player5 = new Player("User 5", boss);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        Thread thread3 = new Thread(player3);
        Thread thread4 = new Thread(player4);
        Thread thread5 = new Thread(player5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
