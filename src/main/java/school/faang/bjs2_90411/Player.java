package school.faang.bjs2_90411;

public class Player {
    private boolean isPlaying = false;
    private int currentTrack = 0;
    private final String[] tracks = {"Artist1 = Song1", "Artist2 = Song2", "Artist3 = Song3"};

    public final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу.");
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentTrack = ((currentTrack + 1) + tracks.length) % tracks.length;
            System.out.println("Следующая песня: " + tracks[currentTrack]);
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrack = (currentTrack - 1 + tracks.length) % tracks.length;
            System.out.println("Следующая песня: " + tracks[currentTrack]);
        }
    }


}
