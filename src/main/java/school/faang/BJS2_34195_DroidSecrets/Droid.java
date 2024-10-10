package school.faang.BJS2_34195_DroidSecrets;

import java.util.Objects;

public class Droid {
    // БЕЗ Ё
    private static final int RUSSIAN_ALPHABET_LENGTH = 32;
    private static final int ENGLISH_ALPHABET_LENGTH = 26;
    private static final char RUSSIAN_ALPHABET_BASE_SMALL = 'а';
    private static final char RUSSIAN_ALPHABET_BASE_BIG = 'А';
    private static final char ENGLISH_ALPHABET_BASE_SMALL = 'a';
    private static final char ENGLISH_ALPHABET_BASE_BIG = 'A';

    public void sendMessage(String message, int encryptKey, Droid droid) {
        validateMessage(message);
        validateDroid(droid);
        droid.receiveMessage(encryptMessage(message, encryptKey), encryptKey);
    }

    public void receiveMessage(String message, int decryptKey) {
        validateMessage(message);
        System.out.println(decryptMessage(message, decryptKey));
    }

    public String encryptMessage(String message, int key) {
        validateMessage(message);
        DroidMessageEncryptor encryptLogic = (messageToEncrypt, encryptKey) -> {
            char[] messageChars = messageToEncrypt.toCharArray();
            for (int i = 0; i < messageChars.length; i++) {
                char currentChar = messageChars[i];
                if (isRussianChar(currentChar)) {
                    char base = Character.isLowerCase(currentChar) ? RUSSIAN_ALPHABET_BASE_SMALL : RUSSIAN_ALPHABET_BASE_BIG;
                    messageChars[i] = (char)(base + (currentChar + encryptKey - base) % RUSSIAN_ALPHABET_LENGTH);
                } else if (isEnglishChar(currentChar)) {
                    char base = Character.isLowerCase(currentChar) ? ENGLISH_ALPHABET_BASE_SMALL : ENGLISH_ALPHABET_BASE_BIG;
                    messageChars[i] = (char)(base + (currentChar + encryptKey - base) % ENGLISH_ALPHABET_LENGTH);
                }
            }
            return new String(messageChars);
        };
        return encryptLogic.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        validateMessage(message);
        DroidMessageEncryptor encryptLogic = (messageToEncrypt, encryptKey) -> {
            char[] messageChars = messageToEncrypt.toCharArray();
            for (int i = 0; i < messageChars.length; i++) {
                char currentChar = messageChars[i];
                if (isRussianChar(currentChar)) {
                    char base = Character.isLowerCase(currentChar) ? RUSSIAN_ALPHABET_BASE_SMALL : RUSSIAN_ALPHABET_BASE_BIG;
                    int shiftValue = (currentChar - encryptKey - base) % RUSSIAN_ALPHABET_LENGTH;
                    // shiftValue может быть отрицательным, тогда неправильно дешифруется: уйдет за пределы кодов буквы алфавита
                    shiftValue = shiftValue > 0 ? shiftValue : RUSSIAN_ALPHABET_LENGTH + shiftValue;
                    messageChars[i] = (char)(base + shiftValue);
                } else if (isEnglishChar(currentChar)) {
                    char base = Character.isLowerCase(currentChar) ? ENGLISH_ALPHABET_BASE_SMALL : ENGLISH_ALPHABET_BASE_BIG;
                    int shiftValue = (currentChar - encryptKey - base) % ENGLISH_ALPHABET_LENGTH;
                    shiftValue = shiftValue > 0 ? shiftValue : ENGLISH_ALPHABET_LENGTH + shiftValue;
                    messageChars[i] = (char)(base + shiftValue);
                }
            }
            return new String(messageChars);
        };
        return encryptLogic.encrypt(message, key);
    }

    private void validateDroid(Droid droid) {
        if (droid == null) {
            throw new IllegalArgumentException("Droid can't be null!");
        }
    }

    private void validateMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Invalid message");
        }
    }

    private boolean isRussianChar(char ch) {
        return ('а' < ch && ch < 'я') || ('А' < ch && ch < 'Я');
    }

    private boolean isEnglishChar(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }
}
