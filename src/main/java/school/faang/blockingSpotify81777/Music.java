package school.faang.blockingSpotify81777;


public class Music {

    public static void main(String[] args) throws InterruptedException {
        Thread threadPlay = new Thread(() -> new Player().play());
        threadPlay.start();
        Thread threadPause = new Thread(() -> new Player().pause());
        threadPause.start();
        Thread threadSkip = new Thread(() -> new Player().skip());
        threadSkip.start();
        Thread threadPrevious = new Thread(() -> new Player().previous());
        threadPrevious.start();

        threadPlay.join();
        threadPause.join();
        threadSkip.join();
        threadPrevious.join();

        System.out.println(Player.isPlaying);

    }
}
