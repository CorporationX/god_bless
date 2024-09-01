package faang.school.godbless.multithreading.spotify;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.setName("playThread");
        pauseThread.setName("pauseThread");
        skipThread.setName("skipThread");
        previousThread.setName("previousThread");

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }

}
