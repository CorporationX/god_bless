package school.faang.star_wars;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
class Droid {
    private final String name;
    private final DroidMessageEncryptor encryptor = (message, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (base + (c - base + key) % 26);
            }
            result.append(c);
        }
        return result.toString();
    };
    private final DroidMessageEncryptor decryptor =
            (message, key) -> encryptor.process(message, 26 - (key % 26));

    public String encryptMessage(String message, int key) {
        log.info("{} шифрует сообщение...", name);
        return encryptor.process(message, key);
    }

    public String decryptMessage(String message, int key) {
        log.info("{} расшифровывает сообщение...", name);
        return decryptor.process(message, key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encrypted = encryptMessage(message, key);
        log.info("{} отправляет зашифрованное сообщение: {}", name, encrypted);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decrypted = decryptMessage(encryptedMessage, key);
        log.info("{} получил и расшифровал сообщение: {}", name, decrypted);
    }
}
