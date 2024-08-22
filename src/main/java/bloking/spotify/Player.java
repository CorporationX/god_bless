package bloking.spotify;


import java.util.Random;

public class Player {
    private final static int MAX_DELAY = 2000;
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() throws InterruptedException {
        synchronized (this.lock) {
            if (this.isPlaying) {
                System.out.println("Музыка уже воспроизводится");
                return;
            }

            this.isPlaying = true;
            this.delay();
            System.out.println("Запуск воспроизведения");
        }
    }

    public void pause() throws InterruptedException {
        synchronized (this.lock) {
            if (this.isPlaying) {
                this.isPlaying = false;
                this.delay();
                System.out.println("Остановка воспроизведения");
                return;
            }

            System.out.println("Музыка не возпроизводится");
        }
    }

    public void previous() throws InterruptedException {
        synchronized (this.lock) {
            if (this.isPlaying) {
                this.isPlaying = false;
                this.delay();
                System.out.println("Перемотка на начало трека");
                return;
            }

            this.isPlaying = true;
            this.delay();
            System.out.println("Воспроизведение предыдущего трека");
        }
    }

    public void skip() {
        System.out.println("Пропуск трека");
    }

    private void delay() throws InterruptedException {
        Thread.sleep(new Random().nextInt(MAX_DELAY));
    }
}
