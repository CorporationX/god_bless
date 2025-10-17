package bjs287377;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Droid {
    private final String name;
    private static final int ASCII_SIZE = 128;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, k) -> transform(msg, k);
        return droidMessageEncryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor droidMessageDecryptor = (msg, k) -> transform(msg, -k);
        return droidMessageDecryptor.encrypt(message, key);
    }

    public String transform(String message, int key) {
        StringBuilder str = new StringBuilder();
        int normalizedKey = ((key % ASCII_SIZE) + ASCII_SIZE) % ASCII_SIZE;

        for (char ch : message.toCharArray()) {
            int shiftedCharNumber = ((int) ch + normalizedKey) % ASCII_SIZE;
            str.append((char) shiftedCharNumber);
        }
        return str.toString();
    }

    public void sendMessage(String message, int key, Droid droid) {
        String encrypted = encryptMessage(message, key);
        System.out.println(name + " sent encrypted message: " + encrypted);
        droid.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println(name + " got and decrypted: " + decryptMessage(message, key));
    }
}
