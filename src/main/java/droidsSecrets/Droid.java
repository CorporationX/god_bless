package droidsSecrets;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (textMessage, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                int symbolCode = (int) message.charAt(i);
                int encryptionSymbolCode;
                if (symbolCode >= 65 && symbolCode <= 90) {
                    encryptionSymbolCode = symbolCode + (encryptionKey % 26);
                    if (encryptionSymbolCode > 90) {
                        encryptedMessage.append((char) (encryptionSymbolCode - 26));
                    } else {
                        encryptedMessage.append((char) encryptionSymbolCode);
                    }
                } else if (symbolCode >= 97 && symbolCode <= 122) {
                    encryptionSymbolCode = symbolCode + (encryptionKey % 26);
                    if (encryptionSymbolCode > 122) {
                        encryptedMessage.append((char) (encryptionSymbolCode - 26));
                    } else {
                        encryptedMessage.append((char) encryptionSymbolCode);
                    }
                } else {
                    encryptedMessage.append(message.charAt(i));
                }
            }
            return encryptedMessage.toString();
        };

        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (textMessage, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                int symbolCode = (int) message.charAt(i);
                int encryptionSymbolCode;
                if (symbolCode >= 65 && symbolCode <= 90) {
                    encryptionSymbolCode = symbolCode - (encryptionKey % 26);
                    if (encryptionSymbolCode < 65) {
                        encryptedMessage.append((char) (encryptionSymbolCode + 26));
                    } else {
                        encryptedMessage.append((char) encryptionSymbolCode);
                    }
                } else if (symbolCode >= 97 && symbolCode <= 122) {
                    encryptionSymbolCode = symbolCode - (encryptionKey % 26);
                    if (encryptionSymbolCode < 97) {
                        encryptedMessage.append((char) (encryptionSymbolCode + 26));
                    } else {
                        encryptedMessage.append((char) encryptionSymbolCode);
                    }
                } else {
                    encryptedMessage.append(message.charAt(i));
                }
            }
            return encryptedMessage.toString();
        };

        return encryptor.encrypt(message, encryptionKey);
    }
}
