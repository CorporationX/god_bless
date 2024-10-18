package school.faang.multithreading.bro;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) throws InterruptedException {

    Game game = new Game();

    List<Player> players = List.of(
        new Player(game, "PLAYER 1"),
        new Player(game, "PLAYER 2"),
        new Player(game, "PLAYER 3"));

    for (int i = 0; i < 100; i++) {

      System.out.println();
      System.out.println(
          "*** Players status " + (i > 0 ? "after round " + i : "at start") + " ***");
      players.forEach(System.out::println);

      if (game.getLives() == 0) {
        System.out.println("**************");
        return;
      }

      if (players.stream().noneMatch(Player::isAlive)) {
        System.out.println("game is over (all players died)");
        return;
      }

      System.out.println(" > > > Start fighting < < <");

      List<Thread> playersThreads = players.stream()
          .filter(player -> player.getLives() > 0)
          .map(player -> new Thread(player, player.getName()))
          .toList();

      playersThreads.forEach(Thread::start);

      playersThreads.forEach((thread -> {
        try {
          thread.join();
        } catch (InterruptedException | RuntimeException e) {
          log.error("caught exception args: {}", args, e);
        }
      }));

    }
  }

}
