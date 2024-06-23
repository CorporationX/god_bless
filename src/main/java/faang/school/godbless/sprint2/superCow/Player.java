package faang.school.godbless.sprint2.superCow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
@Slf4j
public class Player {
  private String name;

  @SneakyThrows
  public void startBattle(@NonNull Boss boss) {
    boss.joinBattle(this);
  }
}
