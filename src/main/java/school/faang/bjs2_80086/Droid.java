package school.faang.bjs2_80086;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class Droid {
    private final String name;
    private final DroidMessageEncryptor encryptor;

    private Optional<String> encryptMessage(String originMessage, int key, DroidMessageEncryptor encryptor) {
        if (cannotProcess(originMessage, encryptor)) {
            log.warn("Invalid decrypt arguments: message='{}', encryptor={}",
                    originMessage, encryptor);
            return Optional.empty();
        }

        return Optional.ofNullable(encryptor.encrypt(originMessage, key));
    }

    private Optional<String> decryptMessage(String originMessage, int key, DroidMessageEncryptor decryptor) {
        if (cannotProcess(originMessage, decryptor)) {
            log.warn("Invalid decrypt arguments: message='{}', decrypt={}",
                    originMessage, decryptor);
            return Optional.empty();
        }
        return Optional.ofNullable(decryptor.encrypt(originMessage, -key));
    }

    public void sendMessage(String name, String message, int key) {
        if (isInvalidMessage(message)) {
            log.debug("Invalid message");
            return;
        }

        Optional<String> encryptedMessage = encryptMessage(message, key, new CaesarCipher().encryptCaesar());
        if (encryptedMessage.isEmpty()) {
            log.debug("Encryption failed for message: '{}' (key: {})", message, key);
            return;
        }
        log.info("{} sent encrypted message: {}", this.name, encryptedMessage.get());
        receiveMessage(name, encryptedMessage.get(), key);
    }

    private void receiveMessage(String name, String encryptedMessage, int key) {
        Optional<String> decryptedMessage = decryptMessage(encryptedMessage, key, this.encryptor);
        if (decryptedMessage.isEmpty()) {
            log.debug("Decryption skipped for message from {}", name);
            return;
        }
        log.info("{} get decrypted message: {}", name, decryptedMessage.get());
    }

    private boolean isInvalidMessage(String message) {
        return message == null || message.isBlank();
    }

    private boolean cannotProcess(String message, DroidMessageEncryptor encryptor) {
        return isInvalidMessage(message) || encryptor == null;
    }


}
