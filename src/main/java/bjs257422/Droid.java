package bjs257422;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@ToString
public class Droid {
    private final String name;
    private final Logger logger = LoggerFactory.getLogger(Droid.class);

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (parameterMessage, parameterKey) -> {
            List<Character> encryptedChars = new ArrayList<>();
            char[] parameterMessageChars = message.toCharArray();
            List<Character> charsFromAlphabet = Alphabet.convertLettersFromAlphabetToCharacters();
            StringBuilder encryptedCharsToStringBuilder = new StringBuilder();
            int encryptedtIndexInAlphabet = 0;
            for (char parameterMessageChar : parameterMessageChars) {
                if (!Character.isLetter(parameterMessageChar)) {
                    encryptedChars.add(parameterMessageChar);
                    continue;
                }
                encryptedtIndexInAlphabet =
                        getEncryptedIndexInAlphabet(encryptionKey, parameterMessageChar,
                                charsFromAlphabet, encryptedtIndexInAlphabet);
                addLettersFromAlphabetToCryptoChars(parameterMessageChar, encryptedChars,
                        charsFromAlphabet, encryptedtIndexInAlphabet);
            }
            encryptedChars.forEach(encryptedCharsToStringBuilder::append);
            return encryptedCharsToStringBuilder.toString();
        };
        return droidMessageEncryptor.encryptOrDecryptMessage(message, encryptionKey);
    }

    private static int getEncryptedIndexInAlphabet(int encryptionKey, char parameterMessageChar,
                                                   List<Character> charsFromAlphabet,
                                                   int encryptedtIndexInAlphabet) {
        if (charsFromAlphabet.contains(Character.toUpperCase(parameterMessageChar))
                && Character.isLetter(parameterMessageChar)) {
            int currentIndexInAlphabet = charsFromAlphabet
                    .indexOf(Character.toUpperCase(parameterMessageChar));
            encryptedtIndexInAlphabet = currentIndexInAlphabet + encryptionKey;
            if (encryptedtIndexInAlphabet >= charsFromAlphabet.size()) {
                encryptedtIndexInAlphabet = (charsFromAlphabet.size()) % encryptedtIndexInAlphabet;
            }
        }
        return encryptedtIndexInAlphabet;
    }

    public String decryptMessage(String message, int decryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (parameterMessage, parameterKey) -> {
            List<Character> decryptedChars = new ArrayList<>();
            char[] parameterMessageChars = message.toCharArray();
            List<Character> charsFromAlphabet = Alphabet.convertLettersFromAlphabetToCharacters();
            List<String> stringsFromAlphabet = Alphabet.convertLettersFromAlphabetToStrings();
            StringBuilder decryptedCharsToString = new StringBuilder();
            int decryptedtIndexInAlphabet = 0;
            for (char parameterMessageChar : parameterMessageChars) {
                if (!Character.isLetter(parameterMessageChar)) {
                    decryptedChars.add(parameterMessageChar);
                    continue;
                }
                decryptedtIndexInAlphabet =
                        getDecryptedIndexInAlphabet(decryptionKey, parameterMessageChar,
                                stringsFromAlphabet, charsFromAlphabet, decryptedtIndexInAlphabet);
                addLettersFromAlphabetToCryptoChars(parameterMessageChar, decryptedChars,
                        charsFromAlphabet, decryptedtIndexInAlphabet);
            }
            decryptedChars.forEach(decryptedCharsToString::append);
            return decryptedCharsToString.toString();
        };
        return droidMessageEncryptor.encryptOrDecryptMessage(message, decryptionKey);
    }

    private static int getDecryptedIndexInAlphabet(int decryptionKey, char parameterMessageChar,
                                                   List<String> stringsFromAlphabet,
                                                   List<Character> charsFromAlphabet, int decryptedtIndexInAlphabet) {
        if (stringsFromAlphabet.contains(String.valueOf(parameterMessageChar).toUpperCase())
                && Character.isLetter(parameterMessageChar)) {
            int currentIndexInAlphabet = charsFromAlphabet.indexOf(Character.toUpperCase(parameterMessageChar));
            decryptedtIndexInAlphabet = currentIndexInAlphabet - decryptionKey;
            if (decryptedtIndexInAlphabet < 0) {
                decryptedtIndexInAlphabet = (decryptedtIndexInAlphabet + 26) % 26;
            }
        }
        return decryptedtIndexInAlphabet;
    }

    private static void addLettersFromAlphabetToCryptoChars(char parameterMessageChar, List<Character> cryptoChars,
                                                            List<Character> charsFromAlphabet,
                                                            int cryptoIndexInAlphabet) {
        if (Character.isUpperCase(parameterMessageChar)) {
            cryptoChars.add(charsFromAlphabet.get(cryptoIndexInAlphabet));
        }
        if (Character.isLowerCase(parameterMessageChar)) {
            cryptoChars.add(Character.toLowerCase(charsFromAlphabet.get(cryptoIndexInAlphabet)));
        }
    }

    public void sendMessage(Droid recipient, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        logger.info("{} отправил зашифрованное сообщение: {}", this, encryptedMessage);
        recipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String message, int decryptionKey) {
        logger.info("{} получил расшифрованное сообщение: {}", this, decryptMessage(message, decryptionKey));
    }
}
