package school.faang.task_49267;

public class Player {

    private PlaybackState isPlaying;

    public synchronized void play() {
        isPlaying = PlaybackState.PLAYING;
        System.out.println("Музыка играет");
    }

    public synchronized void pause() {
        isPlaying = PlaybackState.PAUSED;
        System.out.println("Музыка стоит на паузе");
    }

    public synchronized void skip() {
        if (isPlaying == PlaybackState.PLAYING) {
            System.out.println("Трек пропущен.");
        } else {
            System.out.println("Необходимо воспроизводить музыку, чтобы пропустить трек.");
        }
    }

    public synchronized void previous() {
        isPlaying = PlaybackState.STOPPED;
    }
}
