package school.faang.bjs2_90369;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final Thread playThread = new Thread(player::play);
        final Thread pauseThread = new Thread(player::pause);
        final Thread skipThread = new Thread(player::skip);
        final Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все операции выполнены");
    }
}