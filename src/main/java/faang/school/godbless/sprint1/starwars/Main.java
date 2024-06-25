package faang.school.godbless.sprint1.starwars;

/**
 * @author Evgenii Malkov
 */
public class Main {
  public static void main(String[] args) {
    Droid r2d2 = new Droid();
    Droid c3po = new Droid();
    String message = "May the Force be with you!";
    int encryptionKey = 1;

    System.out.printf("Key: %s, Source: %s%n", encryptionKey, message);
    String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
    System.out.println("Encrypted: " + encryptedMsg);
    String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
    System.out.println("Decrypted: " + msg);
  }
}
