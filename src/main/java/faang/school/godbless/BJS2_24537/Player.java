package faang.school.godbless.BJS2_24537;

import java.util.Deque;
import java.util.LinkedList;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private final Deque<String> playlist = new LinkedList<>();

    public Player() {
        playlist.add("AC/DC");
        playlist.add("Adele");
        playlist.add("The Weeknd");
        playlist.add("Don Toliver");
    }

    public void play() {
        synchronized (lock) {
            if (!playlist.isEmpty()) {
                isPlaying = true;
                System.out.println("Статус: воспроизведение " + playlist.peekFirst());
            } else {
                System.out.println("Плейлист пуст. Воспроизведение невозможно.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Статус: воспроизведение на паузе.");
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!playlist.isEmpty()) {
                playlist.pollFirst();
                if (!playlist.isEmpty()) {
                    System.out.println("Следующий трек: " + playlist.peekFirst());
                    isPlaying = true;
                } else {
                    System.out.println("Плейлист пуст. Воспроизведение завершено.");
                    isPlaying = false;
                }
            } else {
                System.out.println("Плейлист пуст. Пропустить невозможно.");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!playlist.isEmpty()) {
                String currentTrack = playlist.peekFirst();
                playlist.addFirst(currentTrack);
                System.out.println("Предыдущий трек: " + currentTrack);
                isPlaying = true;
            } else {
                System.out.println("Плейлист пуст. Вернуться невозможно.");
            }
        }
    }
}
