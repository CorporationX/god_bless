package school.faang.sprinttwo.secretsofthedroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}