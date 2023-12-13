package faang.school.godbless.secrets_of_droids;
@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryption(String message,int encryptionKey);
}
