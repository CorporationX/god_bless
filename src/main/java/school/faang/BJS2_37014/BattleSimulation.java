package school.faang.BJS2_37014;

public class BattleSimulation {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread player1 = new Thread(new Player("Gamer 1", boss));
        Thread player2 = new Thread(new Player("Gamer 2", boss));
        Thread player3 = new Thread(new Player("Gamer 3", boss));
        Thread player4 = new Thread(new Player("Gamer 4", boss));
        Thread player5 = new Thread(new Player("Gamer 5", boss));

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
            System.out.println("Главный поток был прерван.");
            e.printStackTrace();
        }
    }
}
