package school.faang.droidsecrets;

import lombok.NonNull;

public class Droid {
    private final String name;
    private DroidMessageEncryptor encryptor;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        encryptor = (msg, encryptionKey) -> {
            StringBuilder result = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char baseCharacter = Character.isLowerCase(ch) ? 'a' : 'A';
                    result.append((char) ((ch - baseCharacter + encryptionKey) % 26 + baseCharacter));
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String decryptMessage, int decryptKey) {
        return encryptor.encrypt(decryptMessage, decryptKey);
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int key) {
        String encryptMessage = droid.encryptMessage(message, key);
        System.out.printf("Encrypt message: %s%n", encryptMessage);
    }

    private void receiveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.printf("Decrypt message: %s%n", decryptMessage);
    }
}
