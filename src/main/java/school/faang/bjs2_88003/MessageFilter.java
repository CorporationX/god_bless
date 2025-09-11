package school.faang.bjs2_88003;

import java.util.Objects;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String word);
}
