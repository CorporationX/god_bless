package faang.school.godbless.sprint2.superCow;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
@Getter
public class Boss {
  private final int maxPlayers = 5;
  private final List<Player> currentPlayers = new ArrayList<>();

  @SneakyThrows
  public void joinBattle(Player player) {
    synchronized (this) {
      if (currentPlayers.size() == maxPlayers) {
        this.wait();
      }
      log.info(String.format("%s Присоединился...", player.getName()));
      currentPlayers.add(player);
    }
    doBattle();
  }

  @SneakyThrows
  private void doBattle() {
    log.info(String.format("%s сражаются с боссом...",
        currentPlayers.stream().map(Player::getName).toList()
    ));
    Thread.sleep(500);
    doLeave();
  }

  private synchronized void doLeave() {
    if (!currentPlayers.isEmpty()) {
      log.info(String.format("%s завершил своё сражение...", currentPlayers.get(0).getName()));
      currentPlayers.remove(0);
    }
    this.notify();
  }
}
