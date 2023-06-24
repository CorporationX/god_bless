package faang.school.godbless.droid.secrets;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = ((message1, key1) -> {
            StringBuilder stringBuilderMessage = new StringBuilder();
            for (int i = 0; i < message1.length(); i++) {
                char firstMessage = message1.charAt(i);
                char resultMessage = (char) (firstMessage + key1);
                stringBuilderMessage.append(resultMessage);
            }
            return stringBuilderMessage.toString();
        });
        return droidMessageEncryptor.cipher(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = ((message1, key1) -> {
            StringBuilder stringBuilderMessage = new StringBuilder();
            for (int i = 0; i < message1.length(); i++) {
                char firstMessage = message1.charAt(i);
                char resultMessage = (char) (firstMessage - key1);
                stringBuilderMessage.append(resultMessage);
            }
            return stringBuilderMessage.toString();
        });
        return droidMessageEncryptor.cipher(message, key);
    }
}
