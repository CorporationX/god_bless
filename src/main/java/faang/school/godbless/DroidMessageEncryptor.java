package faang.school.godbless;
@FunctionalInterface

public interface DroidMessageEncryptor {
    String crypt(String message, int key);
}
