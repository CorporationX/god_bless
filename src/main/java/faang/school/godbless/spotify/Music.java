package faang.school.godbless.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Runnable play = () -> player.play();
        Runnable pause = () -> player.pause();
        Runnable skip = () -> player.skip();
        Runnable previous = () -> player.previous();

        Thread thread1 = new Thread(play);
        Thread thread2 = new Thread(pause);
        Thread thread3 = new Thread(skip);
        Thread thread4 = new Thread(previous);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
