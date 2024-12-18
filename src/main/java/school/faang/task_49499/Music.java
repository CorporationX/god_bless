package school.faang.task_49499;

public class Music {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.addSong("Song 3");


        Player player = new Player(playlist);
        Thread playThread = new Thread(player::play);
        playThread.start();
        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();
        Thread skipThread = new Thread(player::skip);
        skipThread.start();
        Thread previousThread = new Thread(player::previous);
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Simulation finished.");
    }
}
