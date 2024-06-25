package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread player1 = new Thread(new Player("Player 1", boss));
        Thread player2 = new Thread(new Player("Player 2", boss));
        Thread player3 = new Thread(new Player("Player 3", boss));
        Thread player4 = new Thread(new Player("Player 4", boss));
        Thread player5 = new Thread(new Player("Player 5", boss));

        player1.start();
        player2.start();
        player3.start();
        player4.start();
        player5.start();
    }
}
