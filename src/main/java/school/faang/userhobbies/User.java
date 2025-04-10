package school.faang.userhobbies;

import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
public class User {
    private final int id;
    private final String name;
    private final int age;
    @Getter
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = (activities != null) ? new HashSet<>(activities) : new HashSet<>();
    }
}
