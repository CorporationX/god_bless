package school.faang.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

}
