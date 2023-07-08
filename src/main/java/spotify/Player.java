package spotify;

public class Player {
    private Object lock;
    private boolean isPlaying;

    public void play(){
        synchronized (lock){
            isPlaying = true;
            System.out.println("Music is playing");
        }
    }

    public void pause(){
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music is paused");
        }
    }

    public void skip(){
        synchronized (lock){
            isPlaying = false;
            System.out.println("Music is skipped");
        }
    }

    public void previous(){
        synchronized (lock){
            isPlaying = false;
            System.out.println("Play previous track");
        }
    }

}
