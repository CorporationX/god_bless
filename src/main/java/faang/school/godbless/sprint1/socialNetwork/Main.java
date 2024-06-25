package faang.school.godbless.sprint1.socialNetwork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    List<UserAction> actions = new ArrayList<>();
    String[] hashTags = new String[]{"#Real", "#France", "#PSG", "#Euro", "#Champions league"};
    Random random = new Random();

    for (long i = 0; i < 50; i++) {
      int randomId = random.nextInt(15);
      int month = random.nextInt(6) + 1;
      int day = random.nextInt(28) + 1;
      int hour = random.nextInt(24);
      int minute = random.nextInt(60);
      LocalDateTime randomDateTime = LocalDateTime.of(2024, month, day, hour, minute, minute);

      actions.add(new UserAction(i, "User" + randomId,
          ActionType.values()[random.nextInt(ActionType.values().length)],
          randomDateTime,
          hashTags[random.nextInt(hashTags.length)] + " " + i));
    }
    actions.forEach(System.out::println);
    log.info(String.format("1. TOP activity users: %s", ActivityAnalyzer.getMostActivityUsers(actions, ActionType.COMMENT, 10)));
    log.info(String.format("2. TOP themes: %s", ActivityAnalyzer.getMostDiscussedThemes(
        actions, List.of(ActionType.POST, ActionType.COMMENT), 5)));
    log.info(String.format("3. TOP users on last month: %s", ActivityAnalyzer.getMostActiveUsersInCommentsOnLastMonth(actions, 3)));
    log.info(String.format("4. Percents: %s", ActivityAnalyzer.countPercentActionType(actions)));
  }

}
