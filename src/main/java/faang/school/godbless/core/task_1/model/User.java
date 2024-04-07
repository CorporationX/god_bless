package faang.school.godbless.core.task_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class User {
    private final String name;
    @Getter
    private final int age;
    private final String workAddress;
    private final String address;
}