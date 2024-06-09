package faang.school.godbless.bjs2_8991;

import java.util.stream.Collectors;

public final class Utils {
  private Utils() {}

  public static DroidMessageEncryptor encryptor = (m, k) -> m.chars()
      .map(ch -> ch - k)
      .mapToObj(ch -> String.valueOf((char) ch))
      .collect(Collectors.joining());

  public static DroidMessageEncryptor receiver = (m, k) -> m.chars()
      .map(ch -> ch + k)
      .mapToObj(ch -> String.valueOf((char) ch))
      .collect(Collectors.joining());

}
