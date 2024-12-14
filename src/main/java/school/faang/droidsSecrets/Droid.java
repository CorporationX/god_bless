package school.faang.droidsSecrets;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiFunction;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class Droid {
  private final int ALPHABET_SIZE = 26;

  private final BiFunction<String, Integer, String> DEFAULT_ENCRYPTOR = (msg, key) -> {
    return msg.chars()
        .mapToObj(c -> (char) c)
        .map(c -> {
          if(Character.isLetter(c)) {
            char firstChar = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) ((c - firstChar + key) % ALPHABET_SIZE + firstChar);
          }
          return c;
        })
        .map(String::valueOf)
        .collect(Collectors.joining());
  };

  private final BiFunction<String, Integer, String> DEFAULT_DECRYPTOR =
      (msg, key) -> DEFAULT_ENCRYPTOR.apply(msg, ALPHABET_SIZE - key);

  private String name;

  public void sendMessage(Droid droid, String msg, int key, BiFunction<String, Integer, String> encryptionFunction) {
    if(key <= 0) {
      throw new IllegalArgumentException("allowed only positive keys");
    }

    String message = encryptMessage(msg, key, encryptionFunction);
    System.out.printf("сообщение зашиврованно и отправлено %s\n", message);
    String response = droid.receiveMessage(message, key, encryptionFunction);
    System.out.printf("сообзение получено дроном %s и расшифрованно %s\n", droid.getName(), response);
  }

  private String receiveMessage(String msg, int key, BiFunction<String, Integer, String> encryptionFunction) {
    return decryptMessage(msg, key, encryptionFunction);
  }

  private String encryptMessage(String msg, int key, BiFunction<String, Integer, String> encryptionFunction) {
    if(encryptionFunction == null) {
      encryptionFunction = DEFAULT_ENCRYPTOR;
    }
    return encryptionFunction.apply(msg, key);
  }

  private String decryptMessage(String msg, int key, BiFunction<String, Integer, String> decryptionFunction) {
    if(decryptionFunction == null) {
      decryptionFunction = DEFAULT_DECRYPTOR;
    }
    return decryptionFunction.apply(msg, key);
  }
}
