package faang.school.godbless.BJS2_1117;

public class Droid {

    String sendEncryptedMessage(String message, int encryptionKey) {

        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder stringBuilder = new StringBuilder();

            for (char ch : message.toCharArray()) {
                if (!Character.isLetter(ch)) {
                    stringBuilder.append(ch);
                    continue;
                }
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int letter = base + (ch - base + encryptionKey) % 26;
                stringBuilder.append((char) letter);
            }
            return stringBuilder.toString();
        };

        String encryptedMessage = encryptor.encrypt(message, encryptionKey);

        return encryptedMessage;
    }


    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder stringBuilder = new StringBuilder();

            for (char ch : encryptedMsg.toCharArray()) {
                if (!Character.isLetter(ch)) {
                    stringBuilder.append(ch);
                    continue;
                }
                char base = Character.isUpperCase(ch) ? 'Z' : 'z';
                int letter = base + (ch - base - encryptionKey) % 26;
                stringBuilder.append((char) letter);
            }
            return stringBuilder.toString();
        };

        String message = decryptor.encrypt(encryptedMsg, encryptionKey);

        return message;
    }
}