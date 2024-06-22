package faang.school.godbless.module1.sprint3.task8;

public class Player {

    private Boolean isPlaying;
    private final Object locked = new Object();

    public void play() {
        synchronized (locked) {
            isPlaying = true;
            System.out.println(" isPlaying " + isPlaying);
        }
        System.out.println(" Music play method - play");
    }

    public void skip() {
        synchronized (locked){
            System.out.println("Skip this ");
            System.out.println(" Music skip method - skip");
            System.out.println(" Next ");
            play();
        }
    }

    public void pause() {
        synchronized (locked) {
            isPlaying = false;
            System.out.println("isPlaying " + isPlaying);
            System.out.println(" Music pause method - pause ");
        }
    }

    public void previous() {
        synchronized (locked){
            System.out.println("Previous start");
            play();
        }
    }

}
