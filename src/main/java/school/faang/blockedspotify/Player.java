package school.faang.blockedspotify;

import lombok.Data;

@Data
public class Player {
    private final String lock;
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Хочу включить плеер. Прошлое действие было: " + getIsPlaying());
            setIsPlaying("play");
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Хочу поставить на паузу, Прошлое действие было: " + getIsPlaying());
            setIsPlaying("pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Хочу пропустить песню. Прошлое действие было: " + getIsPlaying());
            setIsPlaying("skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Включаю предыдущую песню. Прошлое действие было: " + getIsPlaying());
            setIsPlaying("previous");
        }
    }
}
