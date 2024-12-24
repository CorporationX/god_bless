package school.faang.sprint_3.task_49405;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Runnable[] actions = {
                player::play,
                player::pause,
                player::skip,
                player::previous
        };

        IntStream.range(0, actions.length).forEach(i ->
                new Thread(actions[i], "Действие потока " + i).start()
        );

        IntStream.range(1, 4).forEach(i -> {
            new Thread(player::play, "Воспроизведение потока " + i).start();
            new Thread(player::pause, "Остановка потока " + i).start();
        });
    }
}
