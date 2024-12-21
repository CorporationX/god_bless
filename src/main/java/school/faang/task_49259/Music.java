package school.faang.task_49259;

import lombok.SneakyThrows;

public class Music {
    @SneakyThrows
    public static void main(String[] args) {
        Player player = new Player();
        Thread[] threads = {
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::previous),
                new Thread(player::skip),
                new Thread(player::play)
        };

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
