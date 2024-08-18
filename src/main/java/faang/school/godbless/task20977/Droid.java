package faang.school.godbless.task20977;

public class Droid {
    public void sendEncryptedMessage(DroidMassageReceiver recipient, String massage, int encryption){
        FunctionalDroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base + encryptionKey) % 26 + base);
                }
                encryptedMessage.append(c);
            }
            return encryptedMessage.toString();
        };
        String encryptedMessage = encryptor.encrypt(massage, encryption);
        recipient.receiveEncryptedMessage(encryptedMessage, encryption);
    }
}
