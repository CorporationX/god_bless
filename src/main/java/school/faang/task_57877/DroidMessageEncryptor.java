package school.faang.task_57877;

import lombok.NonNull;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String transformMessage(@NonNull String message, int key);
}
