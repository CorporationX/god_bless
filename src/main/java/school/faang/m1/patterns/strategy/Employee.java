package school.faang.m1.patterns.strategy;

import java.util.Objects;
import java.util.Set;

public record Employee(int id, String name, Set<String> skills) {
    public Employee {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(skills, "skills");
        // нормализуем/замораживаем набор навыков
        skills = Set.copyOf(skills);
    }
}
