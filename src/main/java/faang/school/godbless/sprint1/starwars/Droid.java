package faang.school.godbless.sprint1.starwars;

import java.util.stream.Collectors;

/**
 * @author Evgenii Malkov
 */
public class Droid {
  public String sendEncryptedMessage(String message, int key) {
    DroidMessageEncryptor encryptor = (msg, encryptKey) ->
        message.chars()
            .map((c) -> c + key)
            .mapToObj((ch) -> String.valueOf((char) ch))
            .collect(Collectors.joining());
    return encryptor.encrypt(message, key);
  }

  public String receiveEncryptedMessage(String encryptedMsg, int key) {
    DroidMessageEncryptor encryptor = (msg, encryptKey) ->
      encryptedMsg.chars()
          .map((c) -> c - key)
          .mapToObj((ch) -> String.valueOf((char) ch))
          .collect(Collectors.joining());
    return encryptor.encrypt(encryptedMsg, key);
  }
}
