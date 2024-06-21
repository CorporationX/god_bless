package faang.school.godbless.bjs2_12688;

import java.util.List;
import java.util.Random;

public class Player {

  private static final String MUSIC_NOT_PLAYING = "Музыка не грает.";
  private static final String FIRST_TRACK = "Играет певый трек.";
  private static final String LAST_TRACK = "Играет последний трек.";
  private static final String CANNOT_GO_BACK = "Нельзя вернуться к предыдущему треку. ";
  private static final String CANNOT_SKIP = "Нельзя пропустить текущий трек. ";
  private static final String PLAYING_TRACK = "Играет трек - %s.";
  private static final String STOPPING_TRACK = "Трек %s остановлен.";
  private static final String SKIPPING_TRACK = "Пропускаем %s трек.";
  private static final String PREVIOUS_TRACK= "Возвращаемся к предыдущему треку.";
  private static final String EMPTY_VALUE= " ";
  private static final int INCREMENT = 1;
  private static final int DECREMENT= 1;
  private static final int ALBUM_START = 0;
  private static final long DEFAULT_TIME = 300L;

  private static final Object lock = new Object();

  private Boolean isPlaying = Boolean.FALSE;

  private List<String> listMusic;
  private int currentMusicIndex;

  public Player(List<String> listMusic) {
    this.listMusic = listMusic;
  }

  public void play() {
    synchronized (lock) {
      if (!isPlaying) {
        this.isPlaying = Boolean.TRUE;
        currentMusicIndex = new Random().nextInt(listMusic.size() - DECREMENT);
        System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
            String.format(PLAYING_TRACK, getMusic(currentMusicIndex)));
        try {
          Thread.sleep(DEFAULT_TIME);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public void pause() {
    synchronized (lock) {
      if (isPlaying) {
        this.isPlaying = Boolean.FALSE;
        System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
            String.format(STOPPING_TRACK, getMusic(currentMusicIndex)));
      }
    }
  }

  public void skip() {
    synchronized (lock) {
      if (isPlaying) {
        if (currentMusicIndex == listMusic.size()) {
          System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
              CANNOT_SKIP + LAST_TRACK);
        } else {
          System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
              String.format(SKIPPING_TRACK, getMusic(currentMusicIndex)));
          currentMusicIndex += INCREMENT;
          System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
              String.format(PLAYING_TRACK, getMusic(currentMusicIndex)));
          try {
            Thread.sleep(DEFAULT_TIME);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      } else {
        System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
            CANNOT_SKIP + MUSIC_NOT_PLAYING);
      }
    }
  }

  public void previous() {
    synchronized (lock) {
      if (isPlaying) {
        if (currentMusicIndex == ALBUM_START) {
          System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
              CANNOT_GO_BACK + FIRST_TRACK);
        } else {
          System.out.println(Thread.currentThread().getName() + EMPTY_VALUE + PREVIOUS_TRACK);
          currentMusicIndex -= DECREMENT;
          System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
              String.format(PLAYING_TRACK, getMusic(currentMusicIndex)));
          try {
            Thread.sleep(DEFAULT_TIME);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      } else {
        System.out.println(Thread.currentThread().getName() + EMPTY_VALUE +
            CANNOT_GO_BACK + MUSIC_NOT_PLAYING);
      }
    }
  }

  private String getMusic(int index) {
    return listMusic.get(index);
  }
}
