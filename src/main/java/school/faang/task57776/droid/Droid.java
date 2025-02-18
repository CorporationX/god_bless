package school.faang.task57776.droid;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@AllArgsConstructor
public class Droid {
    private static final Logger LOGGER = LoggerFactory.getLogger(Droid.class);
    private static final int UPPERCASE_START = 64;
    private static final int UPPERCASE_END = 91;
    private static final int LOWERCASE_START = 96;
    private static final int LOWERCASE_END = 123;
    private static final int FROM_END_TO_OTHER = 28;
    private String name;

    private void encryptMessage(String message, int encryptionKey, DroidMessageEncryptor droidMessageEncryptor) {
        LOGGER.info("Шифровка сообщения: {} -> Ключ: {}", message, encryptionKey);
        recieveMessage(droidMessageEncryptor.encrypt(message, encryptionKey), encryptionKey);
    }

    private void decryptMessage(String message, int encryptionKey, DroidMessageEncryptor droidMessageEncryptor) {
        LOGGER.info("Получено сообщение дройду: {}", droidMessageEncryptor.encrypt(message, encryptionKey));
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int encryptionKey) {
        LOGGER.info("Отправка сообщения дройду {}", droid);
        encryptMessage(message, encryptionKey, (str, key) -> str.codePoints()
                .map(code -> {
                    if (code > UPPERCASE_START && code < UPPERCASE_END
                            || code > LOWERCASE_START && code < LOWERCASE_END) {
                        if (code < UPPERCASE_END && code + key >= UPPERCASE_END
                                || code + encryptionKey >= LOWERCASE_END) {
                            code += key - FROM_END_TO_OTHER;
                        }
                        code += key;
                    }
                    return code;
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }

    private void recieveMessage(String encryptMessage, int encryptionKey) {
        LOGGER.info("Получено зашифрованное сообщение: {} -> Требуется расшифровка", encryptMessage);
        decryptMessage(encryptMessage, encryptionKey, (str, key) -> str.codePoints()
                .map(code -> {
                    if (code > UPPERCASE_START && code < UPPERCASE_END
                            || code > LOWERCASE_START && code < LOWERCASE_END) {
                        if (code - encryptionKey <= UPPERCASE_START
                                || code > LOWERCASE_START && code - encryptionKey <= LOWERCASE_START) {
                            code += FROM_END_TO_OTHER - encryptionKey;
                        }
                        code -= encryptionKey;
                    }
                    return code;
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
