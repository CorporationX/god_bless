package school.faang.sprint3multythreading.spotify;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread playThread = new Thread(player::play);
        playThread.start();

        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();

        Thread skipThread = new Thread(player::skip);
        skipThread.start();

        Thread previousThread = new Thread(player::previous);
        previousThread.start();

        Thread skipThread3 = new Thread(player::skip);
        skipThread3.start();

        Thread pauseThread2 = new Thread(player::pause);
        pauseThread2.start();

        Thread playThread1 = new Thread(player::play);
        playThread1.start();
    }
}