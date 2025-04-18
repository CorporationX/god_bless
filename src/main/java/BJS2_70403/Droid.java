package BJS2_70403;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class Droid {
    private final String name;

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(final String message, final int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(decryptedMessage);
    }

    private static String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptedKey) -> message
                .chars()
                .map(i -> {
                    if (Character.isUpperCase(i)) {
                        return 'A' + (i - 'A' + key) % 26;
                    } else if (Character.isLowerCase(i)) {
                        return 'a' + (i - 'a' + key) % 26;
                    } else {
                        return i;
                    }
                })
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());

        return encryptor.accept(message, key);
    }

    private static String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptedKey) -> message
                .chars()
                .map(i -> {
                    if (Character.isUpperCase(i)) {
                        return 'A' + (i - 'A' - key + 26) % 26;
                    } else if (Character.isLowerCase(i)) {
                        return 'a' + (i - 'a' - key + 26) % 26;
                    } else {
                        return i;
                    }
                })
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());

        return encryptor.accept(message, key);
    }
}

