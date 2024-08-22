package faang.school.godbless.spotify;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(
                new Thread(player::play, "playerThread"),
                new Thread(player::pause, "pauseThread"),
                new Thread(player::skip, "skipThread"),
                new Thread(player::previous, "previousThread")
        );

        for (var v : threads) {
            v.start();
        }
    }
}
