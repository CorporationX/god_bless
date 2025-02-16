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
    private String name;

    private void encryptMessage(String message, int encryptionKey, DroidMessageEncryptor droidMessageEncryptor) {
        LOGGER.info("Шифровка сообщения: {} -> Ключ: {}", message, encryptionKey);
        recieveMessage(droidMessageEncryptor.encrypt(message, encryptionKey), encryptionKey);
    }

    private void decryptMessage(String message, int encryptionKey, DroidMessageEncryptor droidMessageEncryptor) {
        System.out.println("Получено сообщение дройду: " + droidMessageEncryptor.encrypt(message, encryptionKey));
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int encryptionKey) {
        LOGGER.info("Отправка сообщения дройду {}", droid);
        encryptMessage(message, encryptionKey, (str, key) -> {
            int[] codes = message.codePoints().toArray();
            for (int i = 0; i < codes.length; i++) {
                if (codes[i] > 64 && codes[i] < 91 || codes[i] > 96 && codes[i] < 123) {
                    if (codes[i] < 91 && codes[i] + encryptionKey >= 91
                            || codes[i] < 123 && codes[i] + encryptionKey >= 123) {
                        codes[i] += encryptionKey - 28;
                    }
                    codes[i] += encryptionKey;
                }
            }
            return new String(codes, 0, codes.length);
        });
    }

    private void recieveMessage(String encryptMessage, int encryptionKey) {
        LOGGER.info("Получено зашифрованное сообщение: {} -> Требуется расшифровка", encryptMessage);
        decryptMessage(encryptMessage, encryptionKey, (str, key) -> {
            int[] codes = encryptMessage.codePoints().toArray();
            for (int i = 0; i < codes.length; i++) {
                if (codes[i] > 64 && codes[i] < 91 || codes[i] > 96 && codes[i] < 123) {
                    if (codes[i] > 64 && codes[i] - encryptionKey <= 64
                            || codes[i] > 96 && codes[i] - encryptionKey <= 96) {
                        codes[i] += 28 - encryptionKey;
                    }
                    codes[i] -= encryptionKey;
                }

            }
            return new String(codes, 0, codes.length);
        });
    }

    @Override
    public String toString() {
        return name;
    }
}
