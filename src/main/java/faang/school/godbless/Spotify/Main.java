package faang.school.godbless.Spotify;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Player player2 = new Player();

        Thread SecondplayThread1 = new Thread(() -> player.play());
        Thread playThread = new Thread(() -> player2.play());
        Thread playThread2 = new Thread(() -> player2.play());
        Thread playPauseThread = new Thread(() -> player.pause());
        Thread playPauseThread2 = new Thread(() -> player2.pause());



        playThread.start();
        SecondplayThread1.start();
        playThread2.start();
        playPauseThread.start();
        playPauseThread2.start();


    }
}
