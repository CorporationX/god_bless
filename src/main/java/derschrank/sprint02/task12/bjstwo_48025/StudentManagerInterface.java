package derschrank.sprint02.task12.bjstwo_48025;

import java.util.List;
import java.util.Map;

public interface StudentManagerInterface {
    Map<String, Double> getAverageGradeBySchool(List<Student> students);

    Map<String, Integer> getAverageGradeByStudent(List<Student> students, String firstNameOfStudent, String lastNameOfStudent);

    String getMostHardSubject(List<Student> students);

    void printTableOfStudentsWithGrade(List<Student> students);
}
