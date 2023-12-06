package faang.school.godbless.spotify;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> player.play(new Song("song1","musician1", 0.10)));
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(() -> player.skip(new Song("song2","musician2", 0.10)));
        Thread previousThread = new Thread(() -> player.previous(new Song("song3","musician3", 0.10)));

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
