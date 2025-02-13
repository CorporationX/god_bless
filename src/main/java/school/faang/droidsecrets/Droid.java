package school.faang.droidsecrets;

import lombok.NonNull;

public class Droid {
    private final String name;
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
                character = (char) ((character - baseCharacter + key + 26) % 26 + baseCharacter);
            }
            result.append(character);
        }
        return result.toString();
    };

    public Droid(String name) {
        this.name = name;
    }

    private String encryptMessage(String encriptMessage, int encriptKey) {
        return encrypter.messangeCrypt(encriptMessage, encriptKey);
    }

    private String decryptMessage(String decryptMessage, int decryptKey) {
        return encrypter.messangeCrypt(decryptMessage, -decryptKey);
    }

    public void sendMessage(@NonNull Droid recepientDroid, @NonNull String message, @NonNull int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.println(String.format("Encript message: %s", encryptMessage));
        recepientDroid.receiveMessange(encryptMessage, key);

    }

    private void receiveMessange(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.println(String.format("Decript message: %s", decryptMessage));
    }

}
