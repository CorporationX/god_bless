package faang.school.godbless.BJS212777;

public class Music {
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

        try {
            Thread.sleep(5000);

            player.finishWaiting();

            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();

            System.out.println("All actions finished and all threads closed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupted();
            throw new RuntimeException("Thread interrupted: " + e.getMessage());
        }
    }
}
