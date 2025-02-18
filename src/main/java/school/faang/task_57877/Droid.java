package school.faang.task_57877;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private String name;

    public String encryptMessage(@NonNull String message, int key, @NonNull DroidMessageEncryptor encryptor) {
        return encryptor.transformMessage(message, key);
    }

    public String decryptMessage(@NonNull String message, int key, @NonNull DroidMessageEncryptor decryptor) {
        return decryptor.transformMessage(message, key);
    }

    public void sendMessage(@NonNull String message, int key, @NonNull Droid receiver) {
        String encryptedMessage = processMessage(message, key, true, this::caesarCipher);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(@NonNull String encryptedMessage, int key) {
        processMessage(encryptedMessage, key, false, this::caesarCipher);
    }

    private String processMessage(@NonNull String message, int key, boolean isEncrypt,
                                  @NonNull DroidMessageEncryptor encryptor) {
        String processedMessage = isEncrypt ? encryptMessage(message, key, encryptor)
                : decryptMessage(message, key, encryptor);
        System.out.println(name + (isEncrypt ? " отправляет зашифрованное сообщение: "
                : " получил и расшифровал сообщение: ") + processedMessage);
        return processedMessage;
    }

    private String caesarCipher(@NonNull String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (base + (c - base + key + ALPHABET_SIZE) % ALPHABET_SIZE);
            }
            result.append(c);
        }
        return result.toString();
    }
}
