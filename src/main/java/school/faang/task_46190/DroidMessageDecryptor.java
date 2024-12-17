package school.faang.task_46190;

import java.io.IOException;

@FunctionalInterface
public interface DroidMessageDecryptor {
    String decrypt(String message, int encryptionKey) throws IOException;
}
