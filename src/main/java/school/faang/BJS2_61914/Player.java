package school.faang.BJS2_61914;

public class Player {
    private static final String PLAYER_NOT_PLAYING_MESSAGE = "Плеер не воспроизводит музыку!";
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.print("Музыка уже играет\n");
            } else {
                isPlaying = true;
                System.out.print("Воспроизведение музыки началось \n");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.print("Музыка поставлена на паузу \n");
            } else {
                System.out.printf("%s\n", PLAYER_NOT_PLAYING_MESSAGE);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.print("Переход к следующему треку\n");
            } else {
                System.out.printf("%s Вы не можете пропустить трек\n",
                        PLAYER_NOT_PLAYING_MESSAGE);
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.print("Переход к предыдущему треку\n");
            } else {
                System.out.printf("%s Вы не можете вернуться к предыдущему треку \n",
                        PLAYER_NOT_PLAYING_MESSAGE);
            }
        }
    }
}
