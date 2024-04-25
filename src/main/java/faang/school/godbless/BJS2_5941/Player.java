package faang.school.godbless.BJS2_5941;

public class Player {
  private final static Object LOCK = new Object();
  private boolean isPlaying = false;

  public void play() {
    synchronized (LOCK) {
      if (!isPlaying) {
        isPlaying = true;
        System.out.println("play music");
      }
    }
  }

  public void pause() {
    synchronized (LOCK) {
      if (isPlaying) {
        isPlaying = true;
        System.out.println("pause music");
      }
    }
  }

  public void skip() {
    synchronized (LOCK) {
      System.out.println("skip music");
    }
  }

  public void previous() {
    synchronized (LOCK) {
      System.out.println("previous music");
    }
  }
}
