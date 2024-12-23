package school.faang.bjs246209;

import java.util.function.Function;

@FunctionalInterface
public interface DroidMessageDecryptor extends Function<String, String> {
    @Override
    String apply(String message);
}