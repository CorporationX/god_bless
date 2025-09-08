package school.faang.module1.employee;

import java.util.Set;

public record Employee(Integer id,
                       String name,
                       Set<String> skills) {
}
