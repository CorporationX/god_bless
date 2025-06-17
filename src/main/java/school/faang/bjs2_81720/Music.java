package school.faang.bjs2_81720;

@SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
public class Music {
    private static Player musicPlayer = new Player();

    public static void main(String[] args) {
        Thread playThread = new Thread(musicPlayer::play);
        Thread pauseThread = new Thread(musicPlayer::pause);
        Thread skipThread = new Thread(musicPlayer::skip);
        Thread previousThread = new Thread(musicPlayer::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
