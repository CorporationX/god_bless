package faang.school.godbless.sprint3.task6;

public class Droid {

    public void sendEncryptedMessage(Droid droid, String message, int encryptionKey) {
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


}
