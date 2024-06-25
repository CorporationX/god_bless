package faang.school.godbless.BJS2_12736;

import org.w3c.dom.ls.LSOutput;


// думаю здесь лучше подойдет synchronized по объекту т.к 1 операцию плеера в одно время может выполнять только один поток
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Трек включен...");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Трек на паузе...");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Переключение на следующий трек");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Играет следующий трек...");
            }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Переключение на предыдущий трек");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Играет предыдущий трек..");
        }
    }
}
