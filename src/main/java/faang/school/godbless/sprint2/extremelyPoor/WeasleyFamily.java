package faang.school.godbless.sprint2.extremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class WeasleyFamily {

  public static void main(String[] args) {
    String[] chores = new String[]{"Помыть посуду", "Убрать снег", "Выпить пиво", "Постирать вещи", "Погладить кота"};
    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 0; i < 100000; i ++) {
      for (String c : chores) {
        Chore chore = new Chore(c);
        executor.execute(chore);
      }
    }
    executor.shutdown();
  }
}
