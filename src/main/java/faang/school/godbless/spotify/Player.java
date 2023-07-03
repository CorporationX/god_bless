package faang.school.godbless.spotify;

public class Player {
  private final Object lock = new Object();
  private boolean isPlaying = false;

  public void play() {
    synchronized (lock) {
      isPlaying = true;
      System.out.println("Song has started");
    }
  }

  public void pause() {
    synchronized (lock) {
      isPlaying = false;
      System.out.println("Song has paused");
    }
  }

  public void skip() {
    synchronized (lock) {
      isPlaying = true;
      System.out.println("Skipping to the next song:");
    }
  }

  public void previous() {
    synchronized (lock) {
      isPlaying = true;
      System.out.println("Previous song");
    }
  }
}
