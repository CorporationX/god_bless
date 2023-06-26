package faang.school.godbless.lambda.droidSecrets;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, int key) throws IllegalArgumentException{
        if (encryptedMessage == null || encryptedMessage.isEmpty()) {
            throw new IllegalArgumentException("Переданное сообщение пусто!");
        }

        DroidMessageEncryptor droidMessageDecoder = (str, keyEncrypt) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) - keyEncrypt < 'A' && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    stringBuilder.append((char) ('Z' - ('A' - str.charAt(i) + keyEncrypt) % 26 + 1));
                }
                else if (str.charAt(i) - keyEncrypt < 'a' && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    stringBuilder.append((char) ('z' - ('a' - str.charAt(i) + keyEncrypt) % 26 + 1));
                }
                else if ((str.charAt(i) < 'A' || str.charAt(i) > 'Z') && (str.charAt(i) < 'a' || str.charAt(i) > 'z')) {
                    stringBuilder.append(str.charAt(i));
                }
                else {
                    stringBuilder.append((char) (str.charAt(i) - keyEncrypt));
                }
            }
            return stringBuilder.toString();
        };

        String message = droidMessageDecoder.encrypt(encryptedMessage, key);
        System.out.println("Расшифрованное сообщение: " + message);
        return message;
    }
}
