package school.faang.bjs246232;


import lombok.RequiredArgsConstructor;

import static java.lang.Character.isLetter;

@RequiredArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(Droid droid, String message, int key) {
        if (droid == null || message == null || key == 0) {
            throw new IllegalArgumentException("Argument must be not null !!!");
        }

        String encryptMessage = encryptMessage(message, key, (m, k) -> {
            StringBuilder result = new StringBuilder();
            k = k % 26;

            for (char c : m.toCharArray()) {
                if (isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char shifted = (char) ((c - base + k) % 26 + base);
                    result.append(shifted);
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        });
        System.out.println(getName() + "отправил зашифрованное сообщение: " + encryptMessage);
        System.out.println(droid.getName() + "получил расшифрованное сообщение: " + reviseMessage(encryptMessage, key));
    }

    public String getName() {
        return name;
    }

    public String reviseMessage(String message, int key) {
        return decryptMessage(message, key, (m, k) -> {
            StringBuilder result = new StringBuilder();
            k = k % 26;

            for (char c : m.toCharArray()) {
                if (isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char shifted = (char) ((c - base - k) % 26 + base);
                    result.append(shifted);
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        });
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }
}