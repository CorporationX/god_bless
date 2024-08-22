package faang.school.godbless.javasynchronized.task1;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread= new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        synchronized (player.lock) {
            System.out.println("Is Playing: " + player.isPlaying);
        }
        pauseThread.start();
        synchronized (player.lock) {
            System.out.println("Is Playing: " + player.isPlaying);
        }
        skipThread.start();
        previousThread.start();
    }
}
