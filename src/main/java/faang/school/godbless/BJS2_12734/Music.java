package faang.school.godbless.BJS2_12734;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        var playThread = new Thread(player::play);
        var pauseThread = new Thread(player::pause);
        var skipThread = new Thread(player::skip);
        var previousThread = new Thread(player::previous);
        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
