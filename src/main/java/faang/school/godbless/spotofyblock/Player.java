package faang.school.godbless.spotofyblock;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    public void play(){
        synchronized (lock) {
            isPlaying = true;
        }
    }
    public void pause(){
        synchronized (lock) {
            isPlaying = false;
        }
    }
    public void skip(){
        System.out.println("change song start");
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("change song end");
    }
    public void previous(){
        System.out.println("change song start");
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("change song end");
    }
}
