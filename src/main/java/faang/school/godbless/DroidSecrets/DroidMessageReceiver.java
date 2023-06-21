package faang.school.godbless.DroidSecrets;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, Integer encryptionKey){
        DroidMessageEncryption droidMessageEncryption = (m,k) -> {
            StringBuilder stringBuilder = new StringBuilder(m);
            for (int i = 0; i < stringBuilder.length(); i++) {
                stringBuilder.replace(i, i + 1, String.valueOf(Character.toChars(stringBuilder.charAt(i) - k)[0]));
            }
            return stringBuilder.toString();
        };
        return droidMessageEncryption.encrypt(encryptedMessage,encryptionKey);
    }
}
