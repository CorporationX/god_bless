package school.faang.multithreading.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {

  public static void main(String[] args) {

    Player player = new Player();

    List<Thread> users = new ArrayList<>();

    users.add(new Thread(player::play, "Alexey"));
    users.add(new Thread(player::play, "Boris"));
    users.add(new Thread(player::play, "Daria"));
    users.add(new Thread(player::play, "Evgeny"));
    users.add(new Thread(player::pause, "Fedor"));
    users.add(new Thread(player::pause, "Gloria"));
    users.add(new Thread(player::pause, "Helen"));
    users.add(new Thread(player::skip, "Ivan"));
    users.add(new Thread(player::previous, "Julia"));

    users.forEach(Thread::start);
  }
}
