package school.faang.droidsecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messangeCrypt(String message, int number);
}
