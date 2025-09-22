package school.faang.secrets_of_the_droids;

/**
 * Проект: god_bless
 * Класс DroidMessageEncryptor
 * Автор: Vital
 * Дата: 22.09.2025
 */

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptOrDecrypt(String message, int key);
}
