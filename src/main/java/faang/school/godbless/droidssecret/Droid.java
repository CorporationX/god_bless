package faang.school.godbless.droidssecret;

class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char shifted;
                    if (Character.isUpperCase(c)) {
                        shifted = (char) (((c - 'A' + key) % 26) + 'A');
                    } else {
                        shifted = (char) (((c - 'a' + key) % 26) + 'a');
                    }
                    encryptedMessage.append(shifted);
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int decryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char shifted;
                    if (Character.isUpperCase(c)) {
                        shifted = (char) (((c - 'A' - key + 26) % 26) + 'A');
                    } else {
                        shifted = (char) (((c - 'a' - key + 26) % 26) + 'a');
                    }
                    decryptedMessage.append(shifted);
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, decryptionKey);
    }
}