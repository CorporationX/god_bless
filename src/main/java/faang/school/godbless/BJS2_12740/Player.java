package faang.school.godbless.BJS2_12740;

import lombok.Data;

@Data public class Player {
  private static final Object LOCK = new Object();
  private boolean isPlaying;

  public void play() {
    synchronized (LOCK) {
      if (isPlaying) {
        System.out.println("Музыка уже играет");
      } else {
        System.out.println("Вы включили музыку");
        isPlaying = true;
      }
    }
  }

  public void pause() {
    synchronized (LOCK) {
      if (isPlaying) {
        System.out.println("Музыка и так остановлена");
      } else {
        System.out.println("Вы поставили на паузу музыку");
        isPlaying = false;
      }
    }
  }

  public void skip() {
    synchronized (LOCK) {
      if (isPlaying) {
        System.out.println("Вы включили следующую мызыку");
      } else {
        System.out.println("Музыка не играет, сначала нажмите play");
      }
    }
  }

  public void previous() {
    synchronized (LOCK) {
      if (isPlaying) {
        System.out.println("Вы включили предыдущую мызыку");
      } else {
        System.out.println("Музыка не играет, сначала нажмите play");
      }
    }
  }
}
