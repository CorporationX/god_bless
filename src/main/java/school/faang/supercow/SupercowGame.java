package school.faang.supercow;

public class SupercowGame {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread player1 = new Thread(new Player("Player1", boss));
        Thread player2 = new Thread(new Player("Player2", boss));
        Thread player3 = new Thread(new Player("Player3", boss));
        Thread player4 = new Thread(new Player("Player4", boss));
        Thread player5 = new Thread(new Player("Player5", boss));

        player1.start();
        player2.start();
        player3.start();
        player4.start();
        player5.start();

        try {
            player1.join();
            player2.join();
            player3.join();
            player4.join();
            player5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        boss.showActivePlayers();
        System.out.println("Game session ended.");
    }
}

