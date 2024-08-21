package faang.school.godbless.SpotifyBlock;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread stopThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);
        playThread.start();
        stopThread.start();
        skipThread.start();
        previousThread.start();
    }
}
