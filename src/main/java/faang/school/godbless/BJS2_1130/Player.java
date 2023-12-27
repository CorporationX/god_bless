package faang.school.godbless.BJS2_1130;

public class Player {
    private final Object lock = new Object();
    private String isPlaying;
    public void play(){
        synchronized (lock) {
            isPlaying = "Music is playing";
            System.out.println(isPlaying);
        }
    }

    public void pause(){
        synchronized (lock) {
            isPlaying = "Music on pause";
            System.out.println(isPlaying);
        }
    }

    public void skip(){
        synchronized (lock) {
            isPlaying = "Music was skipped";
            System.out.println(isPlaying);
        }
    }

    public void previous(){
        synchronized (lock) {
            isPlaying = "Music switched to the previous one";
            System.out.println(isPlaying);
        }
    }
}
