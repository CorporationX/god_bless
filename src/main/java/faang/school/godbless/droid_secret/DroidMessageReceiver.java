package faang.school.godbless.droid_secret;

public class DroidMessageReceiver {
    public static String receiveEncryptedMessage(String encryptedMessage, int key){
        DroidMessageEncryptor encryptor = ((encryptedMessage1, key1) -> {

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < encryptedMessage1.length(); i++){
                stringBuilder.append((char) (encryptedMessage1.charAt(i) - key1));
            }

            return stringBuilder.toString();
        });

        return encryptor.encrypt(encryptedMessage, key);
    }
}
