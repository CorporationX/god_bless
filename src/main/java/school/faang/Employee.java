package school.faang;

import java.util.Set;

public record Employee(long id, String name, Set<String> skills) {
}
