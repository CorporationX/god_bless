package droidssecret;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> shiftCharacters(msg, k);
        return encryptor.apply(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, k) -> shiftCharacters(msg, -k);
        return decryptor.apply(message, key);
    }

    public String shiftCharacters(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) ((c - base + shift + 26) % 26 + base);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public void sendMessage(String message, int key, Droid receiver) {
        String encrypted = encryptMessage(message, key);
        System.out.println(this.name + " sends an encrypted message: " + encrypted);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decrypted = decryptMessage(encryptedMessage, key);
        System.out.println(this.name + " received a message: " + decrypted);
    }
}
