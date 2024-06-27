package faang.school.godbless.sprint2.spotify;

import java.util.List;

/**
 * @author Evgenii Malkov
 */
public class Music {
  public static void main(String[] args) {
    Player player = new Player();
    List<Thread> threads = List.of(
        new Thread(player::play, "Play"),
        new Thread(player::pause, "Pause"),
        new Thread(player::skip, "Skip"),
        new Thread(player::previous, "Previous")
    );

    for (Thread thread : threads) {
      thread.start();
    }
  }
}
