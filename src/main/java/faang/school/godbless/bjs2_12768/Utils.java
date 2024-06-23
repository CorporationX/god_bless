package faang.school.godbless.bjs2_12768;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public final class Utils {

  private Utils() {}

  public static <T> T getRandomValueFromList(List<T> lists) {
    return lists.get(new Random().nextInt(lists.size()));
  }

  public static String getRandomString() {
    return UUID.randomUUID().toString();
  }

}
