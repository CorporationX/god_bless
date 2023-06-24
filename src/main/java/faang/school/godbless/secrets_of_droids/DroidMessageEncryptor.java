package faang.school.godbless.secrets_of_droids;

public interface DroidMessageEncryptor {
    String getMessageCode(String message, int key);
}
