package faang.school.godbless.threads.spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;
    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Врубаем музыку " + isPlaying);
        }
    }
    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("На паузу поставили " + isPlaying);
        }
    }
    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Включили след. трек" + isPlaying);
        }
    }
    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Включили пред. трек " + isPlaying);
        }
    }
}
