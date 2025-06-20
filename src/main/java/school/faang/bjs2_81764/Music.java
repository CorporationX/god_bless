package school.faang.bjs2_81764;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread play1 = new Thread(player::play);
        play1.start();
        Thread.sleep(5000);

        Thread play2 = new Thread(player::play);
        play2.start();
        Thread.sleep(5000);

        Thread pause = new Thread(player::pause);
        pause.start();
        Thread.sleep(5000);

        Thread skip = new Thread(player::skip);
        skip.start();
        Thread.sleep(5000);

        Thread previous = new Thread(player::previous);
        previous.start();
        Thread.sleep(5000);
    }
}
