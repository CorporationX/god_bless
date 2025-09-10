package school.faang.bjs2_87418;

public record Droid(String name) {
    public void sendMessage(Droid recipientDroid, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.printf("Дроид %s отправил зашифрованное сообщение: %s\n", name, encryptedMessage);
        recipientDroid.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        System.out.printf("Дроид %s расшифровал сообщение: %s\n", name, decryptedMessage);
    }

    private static String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            char[] encryptedSymbols = new char[msg.length()];
            for (int i = 0; i < msg.length(); i++) {
                char letter = msg.charAt(i);
                if (Character.isLetter(letter)) {
                    char defaultPosition = Character.isUpperCase(letter) ? 'Z' : 'z';
                    int shift = key % 26;
                    encryptedSymbols[i] = letter + shift > defaultPosition ?
                            (char) (letter - (26 - shift)) : (char) (letter + shift);
                } else {
                    encryptedSymbols[i] = letter;
                }
            }
            return String.valueOf(encryptedSymbols);
        };
        return encryptor.encryption(message, encryptionKey);
    }

    private static String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decryptor = (decryptingMessage, key) -> {
            char[] encryptedSymbols = new char[decryptingMessage.length()];
            for (int i = 0; i < decryptingMessage.length(); i++) {
                char letter = decryptingMessage.charAt(i);
                if (Character.isLetter(letter)) {
                    char defaultPosition = Character.isUpperCase(letter) ? 'A' : 'a';
                    int shift = key % 26;
                    encryptedSymbols[i] = letter - shift < defaultPosition ?
                            (char) (letter + (26 - shift)) : (char) (letter - shift);
                } else {
                    encryptedSymbols[i] = letter;
                }
            }
            return String.valueOf(encryptedSymbols);
        };
        return decryptor.encryption(message, encryptionKey);
    }
}
