package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private Boolean isPlaying = false;
    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("начать воспроизведение музыки");
            } else {
                System.out.println("музыка не играет у этого пользователя");
            }
        }
    }
    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("поставить на паузу");
            } else {
                System.out.println("музыка прододжает играть у другого пользователя");
            }
        }
    }
    public void skip() {
        synchronized (lock) {
            System.out.println("пропустить трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("вернуться к предыдущему треку");
        }
    }
}
