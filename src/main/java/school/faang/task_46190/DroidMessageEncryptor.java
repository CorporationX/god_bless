package school.faang.task_46190;

import lombok.Getter;

import java.io.IOException;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey) throws IOException;
}
