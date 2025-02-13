package school.faang;

import java.util.Set;

public class Addresses {
    private Addresses() {
        throw new IllegalArgumentException("Utility class");
    }

    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
}