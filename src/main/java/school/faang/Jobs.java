package school.faang;

import java.util.Set;

public class Jobs {
    private Jobs() {
        throw new IllegalArgumentException("Utility class");
    }

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
}
