package school.faang.multithreading.spotify;

public class Player {

  private final Object lock = new Object();

  private static boolean isPlaying;

  public void play() {
    synchronized (lock) {
      if (isPlaying) {
        System.out.println(getUserName() + " * Music is playing already! *");
      } else {
        isPlaying = true;
        System.out.println(getUserName() + " started playing");
      }
    }
  }

  public void pause() {
    synchronized (lock) {
      if (!isPlaying) {
        System.out.println(getUserName() + " * Music is paused already *");
      } else {
        isPlaying = false;
        System.out.println(getUserName() + " paused playing");
      }
    }
  }

  public void skip() {
    synchronized (lock) {
      System.out.println(getUserName() + " skipping the track");
    }
  }

  public void previous() {
    synchronized (lock) {
      System.out.println(getUserName() + " back to the previous track");
    }
  }

  private static String getUserName() {
    return Thread.currentThread().getName();
  }
}
