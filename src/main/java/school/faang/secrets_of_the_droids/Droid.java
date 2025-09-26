package school.faang.secrets_of_the_droids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Проект: god_bless
 * Класс Droid
 * Автор: Vital
 * Дата: 22.09.2025
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Droid {

    private static final int ALPHABET_SIZE = 26;
    private static final char LOWERCASE_A = 'a';
    private static final char UPPERCASE_A = 'A';

    private String name;
    private DroidMessageEncryptor encryptor;

    public Droid(@NonNull String name) {
        this.name = name;
        this.encryptor = ((messages, key) -> {
            //Шифратор сообщения
            StringBuilder result = new StringBuilder();
            for (char message : messages.toCharArray()) {
                if (Character.isLetter(message)) {
                    char base = Character.isLowerCase(message) ? LOWERCASE_A : UPPERCASE_A;
                    result.append((char) (base + (message - base + key + ALPHABET_SIZE) % ALPHABET_SIZE));
                } else {
                    result.append(message);
                }
            }
            return result.toString();
        });
    }

    //Шифрование сообщения
    public String encryptMessage(@NonNull String message, int key) {
        return encryptor.encryptOrDecrypt(message, key);
    }

    //Дешифратор сообщения
    public String decryptMessage(@NonNull String message, int key) {
        return encryptor.encryptOrDecrypt(message, -key);
    }

    //Отправка сообщения
    public void sendMessage(Droid recipient, @NonNull String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        logMessage("отправил зашифрованное сообщение", encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    //Получение сообщения
    public void receiveMessage(@NonNull String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        logMessage("получил расшифрованное сообщение", decryptedMessage);
    }

    //Вспомогательный метод
    private void logMessage(String action, String message) {
        System.out.println(name + " " + action + ": " + message);
    }
}