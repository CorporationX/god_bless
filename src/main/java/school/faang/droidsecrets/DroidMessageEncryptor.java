package school.faang.droidsecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messageCrypt(String message, int number);
}
