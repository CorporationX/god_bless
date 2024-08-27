package blocking_spotify;

public class Player {

    private boolean isPlaying = false;

    private final Object lock= new Object();

    public void play() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Музыка играет");
        }
    }

    public void pause() {
        synchronized (lock) {
            this.isPlaying = false;
            System.out.println("Музыка не играет");
        }
    }

    public void previous() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Музыка переключилась на предыдущую");
        }
    }

    public void skip() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Музыка переключилась на следующую");
        }
    }
}
