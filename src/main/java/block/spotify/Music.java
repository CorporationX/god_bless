package block.spotify;

import com.sun.tools.javac.Main;

import java.util.List;

public class Music {
    private final Player player = new Player();
    private final List<Thread> threadList =
            List.of(new Thread(player::play),
                    new Thread(player::pause),
                    new Thread(player::skip),
                    new Thread(player::previous));

    public static void main(String[] args) {
        Music music = new Music();
        for (Thread thread : music.threadList) {
            thread.start();
        }
    }
}
