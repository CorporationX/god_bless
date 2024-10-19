package school.faang.droids.secrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    private final DroidMessageEncryptor conversion = (input, key) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char encryptedChunk = (char) (input.charAt(i) ^ key);
                result.append(encryptedChunk);
            }
            return result.toString();
    };

    private String encryptMessage(String message, int key) {
        return conversion.perform(message, key);
    }

    private String decryptMessage(String message, int key) {
        return conversion.perform(message, key);
    }

    private void receiveMessage(String message, int key) {
        message = decryptMessage(message, key);
        System.out.printf("%s received decrypted message: %s\n", this.name, message);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        message = encryptMessage(message, key);
        System.out.printf("%s send encrypted message: %s\n", this.name, message);
        receiver.receiveMessage(message, key);
    }
}
