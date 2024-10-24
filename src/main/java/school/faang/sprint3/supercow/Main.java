package school.faang.sprint3.supercow;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        new Thread(() -> player1.startBattle(boss)).start();
        new Thread(() -> player2.startBattle(boss)).start();
        new Thread(() -> player3.startBattle(boss)).start();
        new Thread(() -> player4.startBattle(boss)).start();
    }
}
