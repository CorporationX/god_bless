package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task02_Spotify;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Thread play = new Thread(()->player.play());
        Thread pause = new Thread(()->player.pause());
        Thread skip = new Thread(()->player.skip());
        Thread previous = new Thread(()->player.previous());

        play.start();
        pause.start();
        skip.start();
        previous.start();
    }
}
