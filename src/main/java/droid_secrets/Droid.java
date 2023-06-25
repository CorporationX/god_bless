package droid_secrets;

public class Droid {
    public void sendEncryptedMessage(Droid droid, String message, int encryptionKey) {
        checkValidation(droid, message);
        DroidMessageEncryptor droidMessageEncryptor = (mess, encryptKey) -> {
            char[] c = mess.toCharArray();
            for (int i = 0; i < c.length; i++) {
                c[i] += encryptKey;
            }
            return String.valueOf(c);
        };
        String messageCrypt = droidMessageEncryptor.encrypt(message, encryptionKey);

        DroidMessageReceiver droidMessageReceiver = new DroidMessageReceiver();
        droidMessageReceiver.receiveEncryptedMessage(droid, messageCrypt, encryptionKey);
    }

    private static void checkValidation(Droid droid, String message) {
        if (droid == null) {
            throw new NullPointerException("Droid не может быть null");
        }
        if (message.isBlank()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым");
        }
    }
}
