package faang.school.godbless.BJS2_12757;

public class Player {
    private static Object lock = new Object();
    private static boolean isPlaying = false;

    public void play(){
        synchronized (lock){
            if(!isPlaying){
                System.out.println("Music is play");
                isPlaying = true;
            }
        }
    }

    public void pause(){
        synchronized (lock){
            if(isPlaying){
                System.out.println("Music is stop");
                isPlaying = false;
            }
        }
    }

    public void skip(){
        synchronized (lock){
            if(isPlaying){
                System.out.println("This song is skip");
                isPlaying = true;
            }
        }
    }

    public void previous(){
        synchronized (lock){
            if (isPlaying){
                System.out.println("enabled last song");
                isPlaying = true;
            }
        }
    }
}
