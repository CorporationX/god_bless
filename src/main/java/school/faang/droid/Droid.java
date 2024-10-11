package school.faang.droid;

public record Droid(String name) {

  public void sendMessage(Droid droidRecipient, String message, int key) {

    String encryptedMessage = encryptMessage(message, key);
    System.out.println(this.name() + " sent encrypted message to " + droidRecipient.name() + ": "
        + encryptedMessage);
    droidRecipient.receiveMessage(this, encryptedMessage, key);
  }

  public void receiveMessage(Droid droidSender, String encryptedMessage, int key) {
    String decryptedMessage = decryptMessage(encryptedMessage, key);
    System.out.println(this.name() + " received decrypted message from " + droidSender.name() + ": "
        + decryptedMessage);
  }

  public static String encryptMessage(String messageToEncrypt, int encryptionKey) {
    DroidMessageEncryptor encryptor = ((message, key) -> applyCezarCipher(message, key, true));
    return encryptor.encrypt(messageToEncrypt, encryptionKey);
  }

  public static String decryptMessage(String messageToDecrypt, int encryptionKey) {
    DroidMessageEncryptor decryptor = ((message, key) -> applyCezarCipher(message, key, false));
    return decryptor.encrypt(messageToDecrypt, encryptionKey);
  }

  public static String applyCezarCipher(String message, int key, boolean isEncryption) {
    StringBuilder encryptedMessage = new StringBuilder();
    int offset = isEncryption ? key : 26 - key;
    for (char ch : message.toCharArray()) {
      if (Character.isLetter(ch)) {
        char baseChar = Character.isUpperCase(ch) ? 'A' : 'a';
        encryptedMessage.append((char) ((ch - baseChar + offset) % 26 + baseChar));
      } else {
        encryptedMessage.append(ch);
      }
    }
    return encryptedMessage.toString();
  }
}
