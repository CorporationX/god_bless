package faang.school.godbless.task20977;

public class DroidMassageReceiver {
    public String receiveEncryptedMessage(String massage, int encryption) {
        FunctionalDroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base - decryptionKey + 26) % 26 + base);
                }
                decryptedMessage.append(c);
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(massage, encryption);
    }
}
