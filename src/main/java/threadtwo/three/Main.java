package threadtwo.three;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2, "Diablo");

        Player[] players = {
                new Player("Tom"),
                new Player("Bob"),
                new Player("Maks"),
                new Player("Jack"),
                new Player("Mary")
        };

        for (Player player : players) {
            new Thread(() -> {
                player.startBattle(boss);
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Ожидание завершилось из-за ошибки.");
                }
                boss.leaveBattle(player);
            }).start();
        }
    }
}
