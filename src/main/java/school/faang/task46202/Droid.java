package school.faang.task46202;

import lombok.Getter;

@Getter
public class Droid {
    private static final int MAX_LETTER_IN_ENGLISH = 26;

    private final String name;

    public Droid(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name can`t be null");
        }
        this.name = name;
    }

    private void validateMessageKey(String string, int key) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("String can`t be null");
        }
        if (key < 0 || key > 26) {
            throw new IllegalArgumentException("the key must be greater than zero");
        }
    }

    private String encryptMessage(String string, int key) {
        validateMessageKey(string, key);

        DroidMessageEncryptor encryptor = (newMessage, keyEncrypt) -> {

            StringBuilder result = new StringBuilder();

            for (char c : newMessage.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    result.append((char) ((c - base + keyEncrypt) % MAX_LETTER_IN_ENGLISH + base));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };

        return encryptor.encrypt(string, key);
    }

    private String decryptMessage(String string, int key) {
        validateMessageKey(string, key);

        DroidMessageEncryptor decryptor = (newMessage, keyDecrypt) -> {
            StringBuilder result = new StringBuilder();

            for (char c : newMessage.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    result.append((char) ((c - base
                            - keyDecrypt + MAX_LETTER_IN_ENGLISH) % MAX_LETTER_IN_ENGLISH + base));
                } else {
                    result.append(c);
                }
            }

            return result.toString();
        };

        return decryptor.encrypt(string, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        validateMessageKey(message, key);
        if (droid == null) {
            throw new IllegalArgumentException("droid can`t be null");
        }

        String encryptMessage = encryptMessage(message, key);

        System.out.println(this.getName() + " отправил зашифрованное сообщение: " + encryptMessage);
        System.out.print(droid.getName());
        receiveMessage(encryptMessage, key);
    }

    private void receiveMessage(String message, int key) {
        validateMessageKey(message, key);

        String decryptMessage = decryptMessage(message, key);

        System.out.println(" получил расшифрованное сообщение: " + decryptMessage);

    }
}
