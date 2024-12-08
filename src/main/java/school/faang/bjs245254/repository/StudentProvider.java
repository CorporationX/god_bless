package school.faang.bjs245254.repository;

import school.faang.bjs245254.model.Student;
import school.faang.bjs245254.model.Subject;

import java.util.List;
import java.util.Map;

public interface StudentProvider {
    void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsGrades);

    void addSubjectForStudent(Student student, Subject subject, Integer grade);

    

}
