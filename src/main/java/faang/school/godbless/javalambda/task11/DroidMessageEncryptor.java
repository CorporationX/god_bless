package faang.school.godbless.javalambda.task11;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryption(String str, Integer encryptionKey);
}
