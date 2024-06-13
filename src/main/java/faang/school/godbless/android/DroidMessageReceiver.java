package faang.school.godbless.android;

@FunctionalInterface
public interface DroidMessageReceiver {

    String receiveEncryptedMessage(String message, int keyEncryption);
}
