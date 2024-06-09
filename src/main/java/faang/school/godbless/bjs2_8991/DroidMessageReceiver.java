package faang.school.godbless.bjs2_8991;

public class DroidMessageReceiver {

  /**
   * Метод для расшифровки переданного сообщения.
   * @param message зашифрованное сообщение/
   * @param key ключ шифрования/
   * @return Возвращает расшифрованное сообщение.
   */
  public String receiveEncryptedMessage(String message, int key) {
    return Utils.receiver.droidCommunication(message, key);
  }

}
