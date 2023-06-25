package faang.school.godbless;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String get(String message, int key);
}
