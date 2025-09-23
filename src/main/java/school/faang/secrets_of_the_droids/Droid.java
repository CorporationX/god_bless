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
    private String name;
    private DroidMessageEncryptor encryptor;

    public Droid(@NonNull String name) {
        this.name = name;
        this.encryptor = ((messages, key) -> {
            //Шифратор сообщения
            StringBuilder result = new StringBuilder();
            for (char message : messages.toCharArray()) {
                if (Character.isLetter(message)) {
                    char base = Character.isLowerCase(message) ? 'a' : 'A';
                    result.append((char) (base + (message - base + key + 26) % 26));
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
        System.out.printf("%s отправил зашифрованное сообщение: %s\n", name, encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    //Получение сообщения
    public void receiveMessage(@NonNull String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.printf("%s получил расшифрованное сообщение: %s\n", name, decryptedMessage);
    }
}