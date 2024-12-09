package faang.school.godbless.sprint_1.task_45274;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentService {
    /**
     * Список предметов и оценок каждого студента
     */
    private final Map<Student, Map<Subject, Integer>> listOfSubjectsAndGradesForEachStudent = new HashMap<>();

    /**
     * Студенты, изучающие каждый предмет
     */
    private final Map<Subject, List<Student>> listOfStudentsStudyingEachSubject = new HashMap<>();
}
