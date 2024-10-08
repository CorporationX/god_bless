package school.faang.task217.functional;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String cipher(String string , int key);
}
