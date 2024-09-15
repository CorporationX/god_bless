package faang.school.godbless.BJS2_5169;

import java.util.function.BiFunction;

public class Droid {

  public String sendEncryptedMessage(String message, int code) {
    return getCoder((ch, key) -> (char) (ch + key)).encode(message, code);
  }

  public String receiveEncryptedMessage(String message, int code) {
    return getCoder((ch, key) -> (char) (ch + key)).encode(message, code);
  }

  private static DroidMessageEncryptor getCoder(BiFunction<Character, Integer, Character> codingLogic) {
    return (mess, key) -> {
      StringBuilder decoded = new StringBuilder();
      for (char ch : mess.toCharArray()) {
        decoded.append(codingLogic.apply(ch, key));
      }
      return decoded.toString();
    };
  }
}
