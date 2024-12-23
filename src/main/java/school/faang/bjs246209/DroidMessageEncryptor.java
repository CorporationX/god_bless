package school.faang.bjs246209;

import java.util.function.Function;

@FunctionalInterface
public interface DroidMessageEncryptor extends Function<String, String> {
    @Override
    String apply(String message);
}
