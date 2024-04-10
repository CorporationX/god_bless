package faang.school.godbless.lambdas.task_11.model;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder messageBuilder = new StringBuilder();
            char[] chars = msg.toCharArray();
            for (char symbol : chars) {
                if (!Character.isLetter(symbol)) {
                    messageBuilder.append((char) (symbol + encryptionKey));
                    continue;
                }
                int startForEncryption = Character.isLowerCase(symbol) ? 'a' : 'A';
                char encryptedSymbol = (char) (((symbol - startForEncryption + key + 26) % 26) + startForEncryption);
                messageBuilder.append(encryptedSymbol);
            }
            return messageBuilder.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int decryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder messageBuilder = new StringBuilder();
            char[] chars = msg.toCharArray();
            for (char symbol : chars) {
                if (!Character.isLetter(symbol)) {
                    messageBuilder.append((char) (symbol - decryptionKey));
                    continue;
                }
                int startForEDecryption = Character.isLowerCase(symbol) ? 'a' : 'A';
                char decryptedSymbol = (char) ((((symbol - startForEDecryption - key) % 26 + 26)) % 26 + startForEDecryption);
                messageBuilder.append(decryptedSymbol);
            }
            return messageBuilder.toString();
        };
        return decryptor.encrypt(message, decryptionKey);
    }
}