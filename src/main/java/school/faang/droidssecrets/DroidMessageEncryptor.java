package school.faang.droidssecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String apply(String message, int key);
}