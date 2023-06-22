package faang.school.godbless.droid;

public class DroidMessageReceiver {
  public String receiveEncryptedMessage(String encryptedMessage, int key) {
    DroidMessageEncryptor messageEncryptor = ((message1, key1) -> {
      StringBuilder decryptedMessage = new StringBuilder();

      for (int i = 0; i < message1.length(); i++) {
        decryptedMessage.append((char) (message1.charAt(i) - key1));
      }

      return decryptedMessage.toString();
    });

    return messageEncryptor.encrypt(encryptedMessage, key);
  }
}
