package faang.school.godbless.secrets_of_droids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptorKey) {
        DroidMessageEncryptor encryptor = (message1, key) -> {
            char[] charsMessage = message.toCharArray();
            StringBuilder builder = new StringBuilder();

            for (char c : charsMessage) {
                int charInt = c + key;
                char newChar = (char) charInt;
                builder.append(newChar);
            }
            return builder.toString();
        };

        return encryptor.getMessageCode(message, encryptorKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            char[] charsMsg = encryptedMsg.toCharArray();
            StringBuilder builder = new StringBuilder();

            for (char c : charsMsg) {
                int charInt = c - key;
                char newChar = (char) charInt;
                builder.append(newChar);
            }
            return builder.toString();
        };
        return encryptor.getMessageCode(encryptedMsg, encryptionKey);
    }

}
