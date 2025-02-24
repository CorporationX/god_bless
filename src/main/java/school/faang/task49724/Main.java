package school.faang.task49724;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player[] players = {
                new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4")
        };

        Thread[] threads = new Thread[players.length];
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            threads[i] = new Thread(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println(player.getName() + " был прерван");
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Ошибка при ожидании завершения потока");
            }
        }
    }
}