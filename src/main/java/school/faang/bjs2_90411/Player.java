package school.faang.bjs2_90411;

public class Player {
    private boolean isPlaying = false;
    private int currentTrack = 0;
    private final String [] tracks = {"Artist1 = Song1", "Artist2 = Song2", "Artist3 = Song3"};

    public synchronized void play() {
        System.out.println("Музыка играет...");
        isPlaying = true;
    }

    public synchronized void pause() {
        System.out.println("Музыка поставлена на паузу");
        isPlaying = false;
    }

    public synchronized void skip() {
        currentTrack = ((currentTrack + 1) + tracks.length) % tracks.length;
        System.out.println("Следующая песня: " + tracks[currentTrack]);
    }

    public synchronized void previous() {
        currentTrack = (currentTrack - 1 + tracks.length) % tracks.length;
        System.out.println("Следующая песня: " + tracks[currentTrack]);
    }


}
