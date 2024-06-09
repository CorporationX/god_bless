package faang.school.godbless.bjs2_8991;

public class Main {

  public static void main(String[] args) {
    Droid redDroid = new Droid();
    Droid greenDroid = new Droid();
    String message = "May the Force be with you!";
    int encryptionKey = 3;

    redDroid.sendEncryptedMessage(greenDroid, message, encryptionKey);

    String greenDroidEncryptedMessage = greenDroid.getSavedMessage();

    System.out.println(greenDroidEncryptedMessage);

    String greenDroidReceiverMessage =
        new DroidMessageReceiver().receiveEncryptedMessage(greenDroidEncryptedMessage, encryptionKey);

    System.out.println(greenDroidReceiverMessage);

  }

}
