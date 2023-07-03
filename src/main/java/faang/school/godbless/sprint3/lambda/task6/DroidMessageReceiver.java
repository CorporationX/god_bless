package faang.school.godbless.sprint3.lambda.task6;

public class DroidMessageReceiver {

    public void receiveEncryptedMessage(Droid droid, String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (mess, encryptKey) -> {
            char[] c = mess.toCharArray();
            for (int i = 0; i < c.length; i++) {
                c[i] -= encryptKey;
            }
            return String.valueOf(c);
        };
        System.out.println(droidMessageEncryptor.encrypt(message, encryptionKey));
    }
}
