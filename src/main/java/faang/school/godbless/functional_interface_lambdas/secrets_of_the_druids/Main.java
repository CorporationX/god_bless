package faang.school.godbless.functional_interface_lambdas.secrets_of_the_druids;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid();
        String originalMessage = "UVWXYZ";

        String encryptedMessage = droid.sendEncryptedMessage(originalMessage, 1, null);
        System.out.println(encryptedMessage);

        String decryptedMessage = droid.receiveEncryptedMessage(encryptedMessage, 1, null);
        System.out.println(decryptedMessage);

    }
}

class Droid {
    private static final int MIN_UPPER_KEY = 65;
    private static final int MAX_UPPER_KEY = 90;
    private static final int MIN_LOWER_KEY = 97;
    private static final int MAX_LOWER_KEY = 122;
    private static final int ALPHABET_SIZE = 26;

    private static final DroidMessageProcessor DROID_MESSAGE_ENCRYPTOR = (msg, key) -> msg.chars()
            .mapToObj(c -> (char) c)
            .map(c -> {
                int code = c + key;
                if ((Character.isUpperCase(c) && code > MAX_UPPER_KEY) || (Character.isLowerCase(c) && code > MAX_LOWER_KEY)) {
                    int minKey = Character.isUpperCase(c) ? MIN_UPPER_KEY : MIN_LOWER_KEY;
                    int maxKey = Character.isUpperCase(c) ? MAX_UPPER_KEY : MAX_LOWER_KEY;
                    code = code % maxKey + minKey - 1;
                }
                return (char) code;
            }).map(String::valueOf)
            .collect(Collectors.joining());

    private static final DroidMessageProcessor DROID_MESSAGE_DECRYPTOR = (msg, key) -> msg.chars()
            .mapToObj(c -> (char) c)
            .map(c -> {
                int code = c - (key % ALPHABET_SIZE);
                if ((Character.isUpperCase(c) && code < MIN_UPPER_KEY) || (Character.isLowerCase(c) && code < MIN_LOWER_KEY)) {
                    int minKey = Character.isUpperCase(c) ? MIN_UPPER_KEY : MIN_LOWER_KEY;
                    int maxKey = Character.isUpperCase(c) ? MAX_UPPER_KEY : MAX_LOWER_KEY;
                    code = maxKey - (minKey - code) + 1;
                }
                return (char) code;
            }).map(String::valueOf)
            .collect(Collectors.joining());

    String sendEncryptedMessage(String msg, int key, DroidMessageProcessor encryptor) {
        if (encryptor == null) {
            encryptor = DROID_MESSAGE_ENCRYPTOR;
        }

        if (key < 0) {
            throw new IllegalArgumentException("Only positive keys are allowed");
        }
        return encryptor.process(msg, key);
    }

    String receiveEncryptedMessage(String msg, int key, DroidMessageProcessor decryptor) {
        if (decryptor == null) {
            decryptor = DROID_MESSAGE_DECRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Only positive keys are allowed");
        }
        return decryptor.process(msg, key);
    }
}

@FunctionalInterface
interface DroidMessageProcessor {
    String process(String msg, int key);
}
