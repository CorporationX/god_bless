package school.faang.droid_secrets;

import java.util.function.Function;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    public String toPerformTheInterface(DroidMessageEncryptor toMessage, String message, int encryptKey) {
        return toMessage.apply(message, encryptKey);
    }

    public String encryptMessage(int encryptKey, String message) {
        return toPerformTheInterface(
                (msg, shift) -> {
                    StringBuilder result = new StringBuilder();
                    for (char character : msg.toCharArray()) {
                        if (Character.isLetter(character)) {
                            char base = Character.isUpperCase(character) ? 'A' : 'a';
                            result.append((char) (((character - base + shift)) % 26 + base));
                        } else {
                            result.append(character);
                        }
                    }
                    return result.toString();
                },
                message,
                encryptKey);
    }

    public String decryptMessage(String message, int encryptKey) {
        return toPerformTheInterface(
                (msg, shift) -> {
                    StringBuilder result = new StringBuilder();
                    for (char character  : msg.toCharArray()) {
                        if (Character.isLetter(character)) {
                            char base = Character.isUpperCase(character) ? 'A' : 'a';
                            result.append((char) ((character - base - shift + 26) % 26 + base));
                        } else {
                            result.append(character);
                        }
                    }
                    return result.toString();
                },
                message,
                encryptKey
        );
    }

    public void sendMessage(Droid droid, String message, int encryptKey) {
        String encryptedMessage = encryptMessage(encryptKey, message);
        System.out.println("Sent message: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptKey);
    }

    public void receiveMessage(String message, int encryptKey) {
        String decryptedMessage = decryptMessage(message, encryptKey);
        System.out.println("Received message: " + decryptedMessage);
    }

}
