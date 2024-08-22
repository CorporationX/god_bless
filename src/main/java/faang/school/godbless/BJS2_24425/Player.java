package faang.school.godbless.BJS2_24425;


public class Player {

    private Object lock = new Object();
    private boolean isPlaying = false;


    public void play() {
        synchronized (lock) {
            System.out.println("music plays");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Музыка на паузе");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Музыка переключилась на следующую");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Музыка переключилась на предыдущую");
            isPlaying = true;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
