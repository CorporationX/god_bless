package faang.school.godbless;

class Droid {
    public void sendEncryptedMessage(DroidMessageReceiver receiver, String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base + key) % 26 + base);
                }
                encryptedMessage.append(c);
            }
            return encryptedMessage.toString();
        };

        String encryptedMessage = encryptor.encrypt(message, encryptionKey);

        receiver.receiveEncryptedMessage(encryptedMessage, encryptionKey);
    }
}
