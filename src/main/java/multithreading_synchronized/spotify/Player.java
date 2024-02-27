package multithreading_synchronized.spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if(!isPlaying) {
                System.out.println("Воспроизведение музыки");
                isPlaying = true;
            }else{
                System.out.println("Музыка включена");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыка поставлена на паузу");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
                System.out.println("Переключить эту песню");
                isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
                System.out.println("Вернуть предыдущую песню");
                isPlaying = true;
        }
    }
}
