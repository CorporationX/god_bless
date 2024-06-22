package faang.school.godbless.spotofyblock;

public class Music {

    public static void main(String[] args) throws java.lang.InterruptedException {
        Player player = new Player();
        Runnable playMethod = player::play;
        Runnable pauseMethod = player::pause;
        Runnable skipMethod = player::skip;
        Runnable prevMethod = player::previous;
        Thread playThread = new Thread(playMethod);
        Thread pauseThread = new Thread(pauseMethod);
        Thread skipThread = new Thread(skipMethod);
        Thread prevThread = new Thread(prevMethod);
        playThread.start();
        pauseThread.start();
        skipThread.start();
        prevThread.start();

        playThread.join();
        pauseThread.join();
        skipThread.join();
        prevThread.join();
    }
}
