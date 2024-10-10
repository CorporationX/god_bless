package school.faang.BJS2_34195_DroidSecrets;

import org.apache.commons.lang3.tuple.Pair;

public class Droid {
    // БЕЗ Ё
    private static final int RUSSIAN_ALPHABET_LENGTH = 32;
    private static final int ENGLISH_ALPHABET_LENGTH = 26;
    private static final char RUSSIAN_ALPHABET_BASE_SMALL = 'а';
    private static final char RUSSIAN_ALPHABET_BASE_BIG = 'А';
    private static final char ENGLISH_ALPHABET_BASE_SMALL = 'a';
    private static final char ENGLISH_ALPHABET_BASE_BIG = 'A';

    private String name;

    public Droid(String name) {
        validateString(name, "Invalid name!");
        this.name = name;
    }

    public void sendMessage(Droid droid, String message, int encryptKey) {
        validateString(message, "Invalid message!");
        validateDroid(droid);
        droid.receiveMessage(encryptMessage(message, encryptKey), encryptKey);
    }

    public void receiveMessage(String message, int decryptKey) {
        validateString(message, "Invalid message!");
        System.out.printf("Droid %s received the message: %s\n", name, decryptMessage(message, decryptKey));
    }

    public String encryptMessage(String message, int key) {
        return processMessage(message, key, true);
    }

    public String decryptMessage(String message, int key) {
        return processMessage(message, key, false);
    }

    private String processMessage(String message, int key, boolean isEncrypting) {
        validateString(message, "Invalid message!");
        DroidMessageEncryptor messageProcessor = (messageToEncrypt, encryptKey) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (char currentChar: message.toCharArray()) {
                if (Character.isLetter(currentChar)) {
                    Pair<Character, Integer> alphabetInfo = getAlphabetBaseAndLength(currentChar);
                    char base = alphabetInfo.getLeft();
                    int alphabetLength = alphabetInfo.getRight();
                    int shiftValue = isEncrypting
                            ? (currentChar + encryptKey - base) % alphabetLength
                            : (currentChar - (encryptKey % alphabetLength) - base + alphabetLength) % alphabetLength;
                    currentChar = (char)(base + shiftValue);
                }
                stringBuilder.append(currentChar);
            }
            return stringBuilder.toString();
        };
        return messageProcessor.encrypt(message, key);
    }

    private Pair<Character, Integer> getAlphabetBaseAndLength(char currentChar) {
        if (isRussianChar(currentChar)) {
            char base = Character.isLowerCase(currentChar) ? RUSSIAN_ALPHABET_BASE_SMALL : RUSSIAN_ALPHABET_BASE_BIG;
            return Pair.of(base, RUSSIAN_ALPHABET_LENGTH);
        } else {
            char base = Character.isLowerCase(currentChar) ? ENGLISH_ALPHABET_BASE_SMALL : ENGLISH_ALPHABET_BASE_BIG;
            return Pair.of(base, ENGLISH_ALPHABET_LENGTH);
        }
    }

    private void validateDroid(Droid droid) {
        if (droid == null) {
            throw new IllegalArgumentException("Droid can't be null!");
        }
    }

    private void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isRussianChar(char ch) {
        return ('а' <= ch && ch <= 'я') || ('А' <= ch && ch <= 'Я');
    }

    private boolean isEnglishChar(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }
}
