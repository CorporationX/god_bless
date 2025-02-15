package school.faang.secretsofdroids;

/**
 * Функциональный интерфейс для шифрования сообщений дроидов.
 * <p>
 * Этот интерфейс предназначен для реализации алгоритмов шифрования или преобразования сообщений
 * с использованием заданного ключа шифрования. Он позволяет определить, как изменять сообщение
 * в зависимости от переданного ключа.
 * </p>
 * <p>
 * Пример использования:
 * <pre>{@code
 * DroidMessageEncryptor encryptor = (message, key) -> {
 *     StringBuilder encryptedMessage = new StringBuilder();
 *     for (char c : message.toCharArray()) {
 *         encryptedMessage.append((char) (c + key));
 *     }
 *     return encryptedMessage.toString();
 * };
 *
 * String encrypted = encryptor.change("Hello, Droids!", 3);
 * System.out.println(encrypted); // Вывод: Khoor, Gurlgv!
 * }</pre>
 * </p>
 */
@FunctionalInterface
public interface DroidMessageEncryptor {
    /**
     * Изменяет (шифрует или преобразует) сообщение с использованием заданного ключа шифрования.
     * <p>
     * Этот метод должен быть реализован для определения логики преобразования сообщения.
     * </p>
     *
     * @param message исходное сообщение, которое необходимо изменить или зашифровать
     * @param encryptionKey ключ шифрования, используемый для преобразования сообщения
     * @return изменённое (зашифрованное) сообщение
     */
    String change(String message, int encryptionKey);
}
