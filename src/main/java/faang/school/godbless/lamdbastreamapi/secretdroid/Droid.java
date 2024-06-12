package faang.school.godbless.lamdbastreamapi.secretdroid;

public record Droid(String name) {
    public static final int LENGTH_ENCODING = 128;
    public String sendEncryptedMessage(String messageEncryption, int keyEncryption) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for(int i = 0; i < message.length(); i++) {
                int asciiCh = ((int) message.charAt(i)) + key;
                if (asciiCh > LENGTH_ENCODING - 1) {
                    asciiCh = asciiCh % LENGTH_ENCODING;
                }
                char ch = (char) asciiCh;
                encryptedMessage.append(ch);
            }

            return encryptedMessage.toString();
        };
        return encryptor.action(messageEncryption, keyEncryption);
    }

    public String receiveEncryptedMessage(String messageEncryption, int keyEncryption) {
        DroidMessageEncryptor decryptor = (message, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                int asciiCh = ((int) message.charAt(i)) - key;
                if (asciiCh < 0) {
                    asciiCh = LENGTH_ENCODING - asciiCh;
                }
                char ch = (char) asciiCh;
                decryptedMessage.append(ch);
            }

            return decryptedMessage.toString();
        };
        return decryptor.action(messageEncryption, keyEncryption);
    }
}
