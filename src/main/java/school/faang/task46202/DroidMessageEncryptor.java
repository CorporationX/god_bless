package school.faang.task46202;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String string, int keyEncrypt);
}
