package school.faang.sprint_1.task_44053;

import lombok.Value;

import java.util.Set;

@Value
public class User {
    int id;
    String name;
    int age;
    Set<String> hobbies;
}
