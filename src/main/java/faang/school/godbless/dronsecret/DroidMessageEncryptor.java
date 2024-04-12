package faang.school.godbless.dronsecret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int cryptCode);
}
