package faang.school.godbless.task.count.student.absences;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class FacultyYear {
    private final String faculty;
    private final int year;
}
