package faang.school.godbless.fun_interfaces_lambdas.task_11;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
