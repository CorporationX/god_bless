package faang.school.godbless.Sprint_3.DroidSecrets;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (mess, k) -> {
            StringBuilder uncifer = new StringBuilder();

            for (int i = 0; i < mess.length(); i++) {
                char oldChar = mess.charAt(i);
                char newChar = (char) ((int) oldChar - k);
                uncifer.append(newChar);
            }
            return uncifer.toString();
        };
        return (droidMessageEncryptor.encrypt(encryptedMessage, key));
    }
}
