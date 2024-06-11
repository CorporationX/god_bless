package faang.school.godbless.bjs2_8991;

/**
 * функциональный интерфейс для передачи зашифрованных сообщений между дроидами.
 */
@FunctionalInterface
public interface DroidMessageEncryptor {
  String droidCommunication(String message, int key);
}
