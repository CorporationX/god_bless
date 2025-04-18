package school.faang.secretsofdroids;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Droid {
    private final String name;

    private final DroidMessageEncryptor caesar = (m, k) -> m.chars()
            .mapToObj(c -> {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int offset = (c - base + k) % 26;
                    if (offset < 0) {
                        offset += 26;
                    }
                    return String.valueOf((char) (base + offset));
                } else {
                    return String.valueOf((char) (c));
                }
            })
            .collect(Collectors.joining());

    public void sendMessage(String message, int key, Droid receiver) {
        String encryptedMessage = encryptMessage(message, key);
        log.info(String.format("Message: \"%s\" was encrypted and sent (droid %s -> droid: %s).",
                message,
                this.getName(),
                receiver.getName()));
        log.info(String.format("encrypted message: [%s]", encryptedMessage));
        receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        System.out.printf("Received message %s\n\n", decryptMessage(encryptedMessage, key));
    }

    private String encryptMessage(String message, int key) {
        return caesar.encryptOrDecrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        return caesar.encryptOrDecrypt(message, -key);
    }
}
