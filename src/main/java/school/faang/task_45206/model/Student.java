package school.faang.task_45206.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Student implements EducationalEntity {
    private final int id;
    private final String name;
}
