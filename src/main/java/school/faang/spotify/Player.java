package school.faang.spotify;

public class Player {
  private final Object lock = new Object();

  private boolean isPlaying;

  public void play() {
    synchronized (lock) {
      System.out.println("включил трек");
      isPlaying = true;
    }
  }

  public void pause() {
    synchronized (lock) {
      System.out.println("трек на паузе");
      isPlaying = false;
    }
  }

  public void skip() {
    synchronized (lock) {
      System.out.println("следующий трек");
    }
  }

  public void previous() {
    synchronized (lock) {
      System.out.println("предыдущий трек");
    }
  }
}
