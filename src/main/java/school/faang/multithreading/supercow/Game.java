package school.faang.multithreading.supercow;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

  private static final int MAX_PLAYERS = 3;

  public static void main(String[] args) {
    Boss boss = new Boss(MAX_PLAYERS);
    List<Player> players = List.of(new Player("ALEX"), new Player("BORIS"), new Player("CELENA"),
        new Player("DMITRY"), new Player("ELENA"), new Player("FEDOR"));

    List<Thread> playersThreads = players.stream()
        .map(player -> new Thread(() -> {
          try {
            player.startBattle(boss);
          } catch (InterruptedException e) {
            log.error("Caught exception args: {}", args, e);
          }
        }, player.getName()))
        .toList();

    playersThreads.forEach(Thread::start);
  }

}
