package school.faang.projectteammanagement;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class Employee {
    private final int id;
    private final String name;
    private Set<String> skills;
}
