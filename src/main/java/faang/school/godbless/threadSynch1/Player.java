package faang.school.godbless.threadSynch1;

public class Player {
    private static final String MESSAGE_MUSIC_PLAYS = "Музыка играет";
    private static final String MESSAGE_MUSIC_STOPPED = "Музыка остановлена";
    private static final String MESSAGE_NEXT_SONG = "Следующая песня";
    private static final String MESSAGE_PREVIOUS_SONG = "Предыдущая песня";
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(MESSAGE_MUSIC_PLAYS);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println(MESSAGE_MUSIC_STOPPED);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(MESSAGE_NEXT_SONG);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(MESSAGE_PREVIOUS_SONG);
        }
    }
}
