package supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        Player player4 = new Player("player4");

        new Thread(() -> player1.startBattle(boss)).start();
        new Thread(() -> player2.startBattle(boss)).start();
        new Thread(() -> player3.startBattle(boss)).start();
        new Thread(() -> player4.startBattle(boss)).start();
    }
}
