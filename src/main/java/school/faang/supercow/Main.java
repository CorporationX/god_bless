package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4, 2);

        Player[] players = {
                new Player("g00d_d4y_to_d13"),
                new Player("HEX: Lockerphilia"),
                new Player("smrinovanton2018"),
                new Player("Andras")
        };

        for (Player player : players) {
            new Thread(() -> player.startBattle(boss)).start();
        }
    }
}
