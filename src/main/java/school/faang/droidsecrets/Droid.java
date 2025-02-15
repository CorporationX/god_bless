package school.faang.droidsecrets;

import lombok.NonNull;

public class Droid {
    private final String name;
    private static final int ALPHABET_SIZE = 26;
    private final DroidMessageEncryptor encrypter = (message, key) -> {
        StringBuilder result = new StringBuilder();
        char baseCharacter;
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    baseCharacter = 'A';
                } else {
                    baseCharacter = 'a';
                }
                character = (char) ((character - baseCharacter + key + ALPHABET_SIZE) % ALPHABET_SIZE + baseCharacter);
            }
            result.append(character);
        }
        return result.toString();
    };

    public Droid(String name) {
        this.name = name;
    }

    private String encryptMessage(String encriptMessage, int encriptKey) {
        return encrypter.messageCrypt(encriptMessage, encriptKey);
    }

    private String decryptMessage(String decryptMessage, int decryptKey) {
        return encrypter.messageCrypt(decryptMessage, -decryptKey);
    }

    public void sendMessage(@NonNull Droid recepientDroid, @NonNull String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.printf("Encript message: %s%n", encryptMessage);
        recepientDroid.receiveMessange(encryptMessage, key);

    }

    private void receiveMessange(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.printf("Decript message: %s%n", decryptMessage);
    }

}
