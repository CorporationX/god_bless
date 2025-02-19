package school.faang.droid_secrets.BJS2_57606;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Droid {
    private static final Logger LOGGER = LoggerFactory.getLogger(Droid.class);

    private static final int ALPHABET_SIZE = 26;

    private static final Map<Character, Integer> ALPHABET_LETTER_AND_ID = IntStream
            .range(0, ALPHABET_SIZE)
            .boxed()
            .collect(Collectors.toMap(
                    i -> (char) ('A' + i),
                    i -> i + 1
            ));
    private static final Map<Integer, Character> ALPHABET_ID_AND_LETTER = IntStream
            .range(0, ALPHABET_SIZE)
            .boxed()
            .collect(Collectors.toMap(
                    i -> i + 1,
                    i -> (char) ('A' + i)
            ));

    private final String name;

    public Droid(String name) {
        validateObjectNull(name == null, " name");
        validateStringIsBlank(name, "name");

        this.name = name;
        LOGGER.info("Created Droid {}", name);
    }

    public void sendMessage(String message, int key, Droid recipientDroid) {
        validateObjectNull(message, " message");
        validateObjectNull(recipientDroid, " recipientDroid");
        validateStringIsBlank(message, "message");
        validateIntIsNegative(key);

        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipientDroid.receiveMessage(encryptedMessage, key);

        LOGGER.info("Message sent");
    }

    public void receiveMessage(String message, int key) {
        validateStringIsBlank(message, "message");
        validateObjectNull(message, " message");
        validateIntIsNegative(key);

        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);

        LOGGER.info("Message received");
    }

    private String encryptMessage(String message, int key) {
        validateStringIsBlank(message, "message");
        validateObjectNull(message, " message");
        validateIntIsNegative(key);

        if (key > ALPHABET_SIZE) {
            key = key % ALPHABET_SIZE;
        }

        DroidMessageEncryptor droidMessageEncryptor =
                (incomingMessage, incomingKey) -> {
                    StringBuilder result = new StringBuilder();
                    for (char c : incomingMessage.toCharArray()) {
                        if (Character.isLetter(c)) {
                            if (Character.isLowerCase(c)) {
                                int id = ALPHABET_LETTER_AND_ID.get(Character.toUpperCase(c));
                                char cipherLetter = Character.toLowerCase(
                                        ALPHABET_ID_AND_LETTER
                                                .get((id + incomingKey - 1) % ALPHABET_SIZE + 1));
                                result.append(cipherLetter);
                            } else if (Character.isUpperCase(c)) {
                                int id = ALPHABET_LETTER_AND_ID.get(c);
                                char cipherLetter = ALPHABET_ID_AND_LETTER
                                        .get((id + incomingKey - 1) % ALPHABET_SIZE + 1);
                                result.append(cipherLetter);
                            } else {
                                result.append(c);
                            }
                        } else {
                            result.append(c);
                        }
                    }
                    return result.toString();
                };
        LOGGER.info("Encrypted message");

        return droidMessageEncryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        validateStringIsBlank(message, "message");
        validateObjectNull(message, " message");
        validateIntIsNegative(key);

        if (key > ALPHABET_SIZE) {
            key = key % ALPHABET_SIZE;
        }

        DroidMessageDecoder droidMessageDecoder =
                (incomingMessage, incomingKey) -> {
                    StringBuilder result = new StringBuilder();
                    for (char c : incomingMessage.toCharArray()) {
                        if (Character.isLetter(c)) {
                            if (Character.isLowerCase(c)) {
                                int id = ALPHABET_LETTER_AND_ID.get(Character.toUpperCase(c));
                                char cipherLetter = Character.toLowerCase(
                                        ALPHABET_ID_AND_LETTER
                                                .get((id - incomingKey - 1 + ALPHABET_SIZE) % ALPHABET_SIZE + 1));
                                result.append(cipherLetter);
                            } else if (Character.isUpperCase(c)) {
                                int id = ALPHABET_LETTER_AND_ID.get(c);
                                char cipherLetter = ALPHABET_ID_AND_LETTER
                                        .get((id - incomingKey - 1 + ALPHABET_SIZE) % ALPHABET_SIZE + 1);
                                result.append(cipherLetter);
                            } else {
                                result.append(c);
                            }
                        } else {
                            result.append(c);
                        }
                    }
                    return result.toString();
                };

        LOGGER.info("Decrypted message");

        return droidMessageDecoder.decipher(message, key);
    }

    public static void validateObjectNull(Object object, String errorMessage) {
        if (object == null) {
            LOGGER.error(errorMessage, (Object) null);
            throw new NullPointerException(String.format(errorMessage, (Object) null));
        }
    }

    private static void validateStringIsBlank(String sender, String fieldName) {
        if (sender.isBlank()) {
            String errorMessage = fieldName + " cannot be blank";
            LOGGER.error("{} cannot be blank", fieldName);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateIntIsNegative(int key) {
        if (key < 0) {
            LOGGER.warn("Key is negative");
            throw new IllegalArgumentException("Key is negative");
        }
    }
}
