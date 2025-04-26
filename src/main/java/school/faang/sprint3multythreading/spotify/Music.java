package school.faang.sprint3multythreading.spotify;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous),
                new Thread(player::skip),
                new Thread(player::pause),
                new Thread(player::play)
        );

        for (Thread thread : threads) {
            thread.start();
        }
    }
}