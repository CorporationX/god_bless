package school.faang.task_49267;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Music implements Runnable {

    private Player player;

    @Override
    public void run() {
        Thread threadPlay = new Thread(() -> player.play());
        Thread threadPause = new Thread(() -> player.pause());
        Thread threadSkip = new Thread(() -> player.skip());

        threadPlay.start();
        threadPause.start();
        threadSkip.start();

    }

    public static void main(String[] args) {
        Player player = new Player();
        Music music = new Music(player);
        Thread thread = new Thread(music);
        thread.start();
    }
}
