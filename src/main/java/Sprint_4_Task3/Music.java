package Sprint_4_Task3;

import lombok.SneakyThrows;

public class Music {
    @SneakyThrows
    public static void main(String[] args) {

        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        playThread.join();
        pauseThread.join();
        skipThread.join();
        previousThread.join();
    }
}
