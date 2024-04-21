package droidsSecrets;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (textMessage, key) -> encryption(message, encryptionKey);
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (textMessage, key) -> encryption(message, -encryptionKey);
        return encryptor.encrypt(message, encryptionKey);
    }

    private String encryption(String message, int encryptionKey) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int symbolCode = message.charAt(i);
            int encryptionSymbolCode;
            if (symbolCode >= 65 && symbolCode <= 90) {
                encryptionSymbolCode = symbolCode + (encryptionKey % 26);
                if (Integer.signum(encryptionKey) == 1 && encryptionSymbolCode > 90 || Integer.signum(encryptionKey) == -1 && encryptionSymbolCode < 65) {
                    encryptedMessage.append((char) (encryptionSymbolCode - (26 * Integer.signum(encryptionKey))));
                } else {
                    encryptedMessage.append((char) encryptionSymbolCode);
                }
            } else if (symbolCode >= 97 && symbolCode <= 122) {
                encryptionSymbolCode = symbolCode + (encryptionKey % 26);
                if (Integer.signum(encryptionKey) == 1 && encryptionSymbolCode > 122 || Integer.signum(encryptionKey) == -1 && encryptionSymbolCode < 97) {
                    encryptedMessage.append((char) (encryptionSymbolCode - (26 * Integer.signum(encryptionKey))));
                } else {
                    encryptedMessage.append((char) encryptionSymbolCode);
                }
            } else {
                encryptedMessage.append(message.charAt(i));
            }
        }
        return encryptedMessage.toString();
    }
}
