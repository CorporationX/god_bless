package faang.school.godbless.Spotify_Cancelling;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Object lock1 = new Object();
        List<String> songs = new ArrayList<>();
        Player myPlayer = new Player(lock1,"Egor Letov", songs);
        Thread playThread = new Thread(() -> myPlayer.play());
        Thread pauseThread = new Thread(() -> myPlayer.pause());
        //Thread previousThread = new Thread();
        Thread skipThread = new Thread(() -> myPlayer.skip());
    }
}
