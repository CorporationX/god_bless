package faang.school.godbless.Spotify;

public class Player {
    private Music music;
    private boolean isPlaying;

    public Player(Music music) {
        this.music = music;
    }

    public void play() {
        synchronized (music) {
            String statusMassage = isPlaying ? "the music is already playing" : "the music played";
            System.out.println(statusMassage);
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (music) {
            String statusMassage = isPlaying ? "the music paused" : "the music is already paused";
            System.out.println(statusMassage);
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (music) {
            String statusMassage = isPlaying ? "the music skipped" : "the music is already skipped and played";
            System.out.println(statusMassage);
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (music) {
            String statusMassage = isPlaying ? "the previous music set" : "the previous music set and played";
            System.out.println(statusMassage);
            isPlaying = true;
        }
    }
}
