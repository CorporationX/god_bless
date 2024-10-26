package school.faang.bjs2_36902;

public class BattleSimulation {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread player1 = new Thread(new Player("Player 1"));
        Thread player2 = new Thread(new Player("Player 2"));
        Thread player3 = new Thread(new Player("Player 3"));
        Thread player4 = new Thread(new Player("Player 4"));
        Thread player5 = new Thread(new Player("Player 5"));
        Thread player6 = new Thread(new Player("Player 6"));

        player1.start();
        player2.start();
        player3.start();
        player4.start();
        player5.start();
        player6.start();
    }
}
