package school.faang.bjs2_32525.service;

import school.faang.bjs2_32525.model.Student;
import school.faang.bjs2_32525.model.Subject;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StudentValidateService {

    private void validateNotNull(Object object, String messageError) {
        if (object == null) {
            throw new IllegalArgumentException(messageError);
        }
    }

    public void validateArgsRemoveStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        validateNotNull(student, ValidationMessages.ERR_MESSAGE_STUDENT_IS_NULL);
        validateNotNull(studentsWithGradesBySubjects, ValidationMessages.ERR_MESSAGE_STUDENTS_WITH_GRADES_BY_SUBJECTS_IS_NULL);

    }

    public void validateArgsAddSubjectWithGradesToStudent(Student student, Subject subject, int grade, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        validateNotNull(student, ValidationMessages.ERR_MESSAGE_STUDENT_IS_NULL);
        validateNotNull(studentsWithGradesBySubjects, ValidationMessages.ERR_MESSAGE_STUDENTS_WITH_GRADES_BY_SUBJECTS_IS_NULL);
        validateNotNull(subject, ValidationMessages.ERR_MESSAGE_SUBJECT_IS_NULL);

        if (!(studentsWithGradesBySubjects.containsKey(student))) {
            throw new NoSuchElementException("there is no such student in the map yet");
        }

        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        if (subjectIntegerMap.containsKey(subject)) {
            throw new IllegalArgumentException("there is already such a subject");
        }

        int minGrade = 2;
        if (grade < minGrade) {
            throw new IllegalArgumentException("grade = " + grade + " cannot be less than the minimum estimate = " + minGrade);
        }
        int maxGrade = 5;
        if (grade > maxGrade) {
            throw new IllegalArgumentException("grade = " + grade + " cannot be higher than the maximum score = " + maxGrade);
        }

    }

    public void validateArgsMethodAddStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        validateNotNull(student, ValidationMessages.ERR_MESSAGE_STUDENT_IS_NULL);
        validateNotNull(gradesBySubjects, ValidationMessages.ERR_MESSAGE_GRADES_BY_SUBJECTS_IS_NULL);
        validateNotNull(studentsWithGradesBySubjects, ValidationMessages.ERR_MESSAGE_STUDENTS_WITH_GRADES_BY_SUBJECTS_IS_NULL);

        if (gradesBySubjects.isEmpty()) {
            throw new IllegalArgumentException("grades by subjects map is empty");
        }
        if (studentsWithGradesBySubjects.containsKey(student)) {
            throw new IllegalArgumentException("there is already such a student");
        }
    }

    public void validateArgsAddSubjectWithStudents(Subject subject, List<Student> students, Map<Subject, List<Student>> studentsBySubject) {
        validateNotNull(subject, ValidationMessages.ERR_MESSAGE_SUBJECT_IS_NULL);
        validateNotNull(students, ValidationMessages.ERR_MESSAGE_STUDENTS_IS_NULL);
        validateNotNull(studentsBySubject, ValidationMessages.ERR_MESSAGE_STUDENTS_BY_SUBJECT_IS_NULL);
        if (students.isEmpty()) {
            throw new IllegalArgumentException("students is empty");
        }
        if (studentsBySubject.containsKey(subject)) {
            throw new IllegalArgumentException("there is already such a subject");
        }
    }

    public void validateArgsAddStudentToSubject(Subject subject, Student student, Map<Subject, List<Student>> studentsBySubject) {
        validateNotNull(subject, ValidationMessages.ERR_MESSAGE_SUBJECT_IS_NULL);
        validateNotNull(student, ValidationMessages.ERR_MESSAGE_STUDENT_IS_NULL);
        validateNotNull(studentsBySubject, ValidationMessages.ERR_MESSAGE_STUDENTS_BY_SUBJECT_IS_NULL);

        if (!(studentsBySubject.containsKey(subject))) {
            throw new NoSuchElementException("there is no such subject");
        }
        List<Student> students = studentsBySubject.get(subject);
        if (students.contains(student)) {
            throw new IllegalArgumentException("such a student is already on the list");
        }
    }

    public void validateRemoveStudentFromSubject(Subject subject, Student student, Map<Subject, List<Student>> studentsBySubject) {
        validateNotNull(student, ValidationMessages.ERR_MESSAGE_STUDENT_IS_NULL);
        validateNotNull(subject, ValidationMessages.ERR_MESSAGE_SUBJECT_IS_NULL);
        validateNotNull(studentsBySubject, ValidationMessages.ERR_MESSAGE_STUDENTS_BY_SUBJECT_IS_NULL);
    }
}
