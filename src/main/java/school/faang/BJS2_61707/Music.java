package school.faang.BJS2_61707;

import lombok.NonNull;

public class Music {
    private final Thread[] threads;

    public Music(@NonNull Player player) {

        threads = new Thread[]{
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        };
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        Music music = new Music(new Player());
        music.start();
    }
}
