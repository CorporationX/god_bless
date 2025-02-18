package school.faang.BJS2_61707;

public class Music {
    private final Thread[] threads;

    public Music() {
        Player player = new Player();

        Runnable playRun = player::play;
        Runnable pauseRun = player::pause;
        Runnable skipRun = player::skip;
        Runnable previousRun = player::previous;

        threads = new Thread[]{
                new Thread(playRun),
                new Thread(pauseRun),
                new Thread(skipRun),
                new Thread(previousRun)
        };
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        Music music = new Music();
        music.start();
    }
}
