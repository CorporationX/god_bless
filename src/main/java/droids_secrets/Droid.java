package droids_secrets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        return IntStream.range(0, message.length())
                .mapToObj(i -> {
                    char ch = message.charAt(i);
                    if (Character.isLetter(ch)) {
                        return (char)(ch + encryptionKey);
                    }
                    return ch;
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        return IntStream.range(0, message.length())
                .mapToObj(i -> (char)(message.charAt(i) - encryptionKey))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
