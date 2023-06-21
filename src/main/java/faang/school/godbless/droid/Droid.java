package faang.school.godbless.droid;

public class Droid {
  public String sendEncryptedMessage(Droid target, String message, int key) {
    DroidMessageEncryptor messageEncryptor = ((message1, key1) -> {
      StringBuilder encryptedMessage = new StringBuilder();

      for (int i = 0; i < message1.length(); i++) {
        encryptedMessage.append((char) (message1.charAt(i) + key1));
      }

      return encryptedMessage.toString();
    });


    return messageEncryptor.encrypt(message, key);
  }
}
