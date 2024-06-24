package faang.school.godbless.multithreading.spotify;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread playThread2 = new Thread(player::play);
        Thread skipThread = new Thread(player::skip);
        Thread pauseThread = new Thread(player::pause);
        Thread previosThread = new Thread(player::previos);

        playThread.start();
        playThread2.start();
        skipThread.start();
        pauseThread.start();
        previosThread.start();

        playThread.join();
        playThread2.join();
        skipThread.join();
        pauseThread.join();
        previosThread.join();
        System.out.println("Все потоки завершились");

    }
}
