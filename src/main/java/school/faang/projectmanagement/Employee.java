package school.faang.projectmanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Employee {
    private final int id;
    private final String name;
    private final Set<String> skills;
}