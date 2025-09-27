package school.faang.bjs2_90442;

public class Player {
    private boolean isPlaying;
    private int currentTrack = 1;
    private final int totalTracks = 5;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            String name = Thread.currentThread().getName();
            if (isPlaying) {
                System.out.println("[" + name + "] " + "Уже играет трек № " + currentTrack);
            } else {
                isPlaying = true;
                System.out.println("[" + name + "] " + "Старт воспроизведения. Сейчас играет трек № " + currentTrack);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            String name = Thread.currentThread().getName();
            if (isPlaying) {
                isPlaying = false;
                System.out.println("[" + name + "] " + "Воспроизводился трек № "
                        + currentTrack + ", но трек поставили на паузу");
            } else {
                System.out.println("[" + name + "] " + "Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            String name = Thread.currentThread().getName();
            currentTrack = (currentTrack % totalTracks) + 1;
            System.out.println("[" + name + "] " + "Пропуск → теперь выбран трек № " + currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            String name = Thread.currentThread().getName();
            currentTrack = (currentTrack - 2 + totalTracks) % totalTracks + 1;
            System.out.println("[" + name + "] " + "Назад → теперь выбран трек № " + currentTrack);
        }
    }
}