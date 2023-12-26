package faang.school.godbless.spotify;

import java.util.List;

public class Player {

    private static final Object lock = new Object();
    private boolean isPlaying = false;
    public List<String> songs = List.of("Linkin Park - Faint", "The Red Jumpsuit Apparatus - Senioritis",
            "Yellowcard - Fighting", "Slipknot - Wait and Bleed", "Kendrick Lamar - Money Trees");
    public static String currentSong;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                if (currentSong == null) {
                    currentSong = songs.get(0);
                }
                System.out.println("Сейчас играет: " + currentSong);
                isPlaying = true;
            }
        }

    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Пауза.");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                int index = songs.indexOf(currentSong);
                int nextIndex = index + 1;
                if (nextIndex >= songs.size()) {
                    currentSong = songs.get(0);
                }
                currentSong = songs.get(index + 1);
                System.out.println("Следующая песня.");
                System.out.println("Сейчас играет: " + currentSong);
                isPlaying = true;
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                int index = songs.indexOf(currentSong);
                int prevIndex = index - 1;
                if (prevIndex <= 0) {
                    currentSong = songs.get(songs.size() - 1);
                } else {
                    currentSong = songs.get(index - 1);
                }
                System.out.println("Предыдущая песня.");
                System.out.println("Сейчас играет: " + currentSong);
                isPlaying = true;
            }
        }
    }
}
