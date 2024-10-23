package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4, 2);

        Player player1 = new Player("g00d_d4y_to_d13");
        Player player2 = new Player("HEX: Lockerphilia");
        Player player3 = new Player("smrinovanton2018");
        Player player4 = new Player("Andras");

        new Thread(() -> player1.startBattle(boss)).start();
        new Thread(() -> player2.startBattle(boss)).start();
        new Thread(() -> player3.startBattle(boss)).start();
        new Thread(() -> player4.startBattle(boss)).start();
    }
}
