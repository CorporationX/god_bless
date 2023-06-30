package faang.school.godbless.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
  public static void main(String[] args) {
    Player PLAYER = new Player();
    ExecutorService service = Executors.newFixedThreadPool(4);

    service.execute(PLAYER::play);
    service.execute(PLAYER::pause);
    service.execute(PLAYER::skip);
    service.execute(PLAYER::pause);
    service.execute(PLAYER::previous);

    service.shutdown();
  }
}
