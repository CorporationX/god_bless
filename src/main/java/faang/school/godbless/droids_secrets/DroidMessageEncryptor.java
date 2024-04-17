package faang.school.godbless.droids_secrets;

@FunctionalInterface
interface DroidMessageEncryptor {
    String encryptMessage(String message, int encryptionKey);
}
