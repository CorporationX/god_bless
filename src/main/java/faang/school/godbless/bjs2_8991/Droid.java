package faang.school.godbless.bjs2_8991;

import lombok.Data;

@Data
public class Droid {
  private String savedMessage;

  /**
   * Метод для шифрования сообщения (строки)
   * @param droid Дроид, которому мы передаем сообщение
   * @param message передаваемое сообщение
   * @param key ключ шифрования
   */
  public void sendEncryptedMessage(Droid droid, String message, int key) {
    droid.savedMessage = Utils.encryptor.droidCommunication(message, key);
  }

}
