package faang.school.godbless.sprint2.spotify;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Player {
  private final Object lock = new Object();
  private boolean isPlaying;

  public void play() {
    synchronized (lock) {
      log.info(
          String.format("Play play play! Thread: %s. isPlaying = %s",
              Thread.currentThread().getName(), isPlaying
          ));
      isPlaying = true;
      log.info("But now: " + isPlaying);
      System.out.println();
    }
  }

  public void pause() {
    synchronized (lock) {
      log.info(
          String.format("Pause now... Thread: %s. isPlaying = %s", Thread.currentThread().getName(),
              isPlaying
          )
      );
      isPlaying = false;
      log.info("But now: " + isPlaying);
      System.out.println();
    }
  }

  public void skip() {
    synchronized (lock) {
      log.info(String.format("Skip. Next track: ... Thread: %s. isPlaying = %s",
              Thread.currentThread().getName(), isPlaying
          )
      );
      log.info("But now without changes: " + isPlaying);
      System.out.println();
    }
  }

  public void previous() {
    synchronized (lock) {
      log.info(String.format("previous track... Thread: %s. isPlaying = %s",
              Thread.currentThread().getName(), isPlaying
          )
      );
      log.info("But now without changes: " + isPlaying);
      System.out.println();
    }
  }
}
