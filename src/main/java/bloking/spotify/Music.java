package bloking.spotify;

import lombok.SneakyThrows;

public class Music {
    @SneakyThrows
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> {
            try {
                player.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread pauseThread = new Thread(() -> {
            try {
                player.pause();
                player.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> {
            try {
                player.previous();
                player.previous();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        playThread.join();
        pauseThread.join();
        skipThread.join();
        previousThread.join();
        System.out.println("Все действия были выполнены");
    }
}
