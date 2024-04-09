package faang.school.godbless.functionalInterfaces.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int encryptionKey);
}
