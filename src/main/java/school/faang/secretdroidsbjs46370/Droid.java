package school.faang.secretdroidsbjs46370;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        return shiftMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        return shiftMessage(message, -key);
    }

    private String shiftMessage(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) (((ch - base + key + 26) % 26) + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " sent an encrypted message: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(name + " take decrypted message: " + decryptedMessage);
    }
}
