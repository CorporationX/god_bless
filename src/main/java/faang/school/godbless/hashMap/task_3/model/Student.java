package faang.school.godbless.hashMap.task_3.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private final String name;
    private final String faculty;
    private final int year;
}