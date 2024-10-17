package school.faang.task321.music;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
public class Music {
    public static void main(String[] args) {
        Object object = new Object();

        Player player = new Player(true, object);

        Thread musicPlay = new Thread(player::play);
        Thread musicStop = new Thread(player::stop);
        Thread musicSkip = new Thread(player::skip);
        Thread musicPrevious = new Thread(player::previous);

        Thread[] threads = new Thread[]{musicPlay, musicStop, musicSkip, musicPrevious};

        for (Thread thread :threads){
            thread.start();
        }

        for (Thread thread :threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
