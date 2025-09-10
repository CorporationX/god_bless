package school.faang.functional_interfaces_lambdas.sekrety_droidov_BJS2_87409;

import lombok.Getter;

public class Droid {
    private final DroidMessageEncryptor droidConvertedMessage = (String message, int encryptionKey) -> {
        if (message == null || message.isBlank()) {
            throw new RuntimeException("Текст сообщения отсутствует");
        }

        StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int alphabetLength = alphabet.length();
        int messageLength = message.length();
        int positionOfCharacter;
        int newPositionOfCharacter;
        int keyEncryption = encryptionKey;
        Boolean isEncryption = encryptionKey >= 0;

        StringBuilder convertedMessage = new StringBuilder();
        if (!isEncryption) {
            alphabet.reverse();
            keyEncryption = keyEncryption * (-1);
        }
        for (int i = 0; i < messageLength; i++) {
            positionOfCharacter = alphabet.indexOf(message.substring(i, i + 1));
            if (positionOfCharacter != -1) {
                newPositionOfCharacter = positionOfCharacter + keyEncryption;
                if (newPositionOfCharacter >= alphabetLength) {
                    newPositionOfCharacter = newPositionOfCharacter - alphabetLength;
                }
                convertedMessage.append(alphabet.charAt(newPositionOfCharacter));
            } else {
                convertedMessage.append(message.charAt(i));
            }
        }
        return convertedMessage.toString();
    };
    @Getter
    private final String nameDroid;

    public Droid(String nameDroid) {
        this.nameDroid = nameDroid;
    }

    private String encryptMessage(String message, int encryptionKey) {
        return droidConvertedMessage.encrypt(message, encryptionKey);
    }

    private String decryptMessage(String message, int encryptionKey) {
        return droidConvertedMessage.encrypt(message, (-1) * encryptionKey);
    }

    public void receiveMessage(String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        System.out.println(this.getNameDroid() + " oтправил расшифрованное сообщение: " + decryptedMessage);
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(this.getNameDroid() + " oтправил зашифрованное сообщение: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptionKey);
    }
}