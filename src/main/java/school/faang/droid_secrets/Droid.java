package school.faang.droid_secrets;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Droid {
    private final String name;

    DroidMessageEncryptor encryptor = (msg, key) -> msg.chars()
            .mapToObj(c -> shiftChar((char) c, key))
            .collect(Collectors.joining());

    public String encryptMessage(String message, int encryptionKey) {
        return encryptor.translate(message, encryptionKey);
    }

    public String decryptMessage(String message, int encryptionKey) {
        return encryptor.translate(message, -encryptionKey);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encrypted = encryptMessage(message, key);
        log.info("{} sent a message {} to {}",
                this.name, encryptMessage(message, key), droid.getName());
        droid.receiveMessage(this, encrypted, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        log.info("{} received a message {} from {}",
                this.name, decryptMessage(message, key), droid.getName());
    }

    private static String shiftChar(char ch, int key) {
        if (Character.isUpperCase(ch)) {
            return String.valueOf((char) (((ch - 'A' + key) % 26 + 26) % 26 + 'A'));
        } else if (Character.isLowerCase(ch)) {
            return String.valueOf((char) (((ch - 'a' + key) % 26 + 26) % 26 + 'a'));
        } else {
            return String.valueOf(ch);
        }
    }
}