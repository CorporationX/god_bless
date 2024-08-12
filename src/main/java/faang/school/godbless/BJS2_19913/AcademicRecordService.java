package faang.school.godbless.BJS2_19913;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AcademicRecordService {

    private Map<Student, Map<Subject, Integer>> gradesByStudents;
    private Map<Subject, List<Student>> studentsSubjects;

    public AcademicRecordService() {
        this.gradesByStudents = new HashMap<>();
        this.studentsSubjects = new HashMap<>();
    }

    public void putStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        gradesByStudents.put(student, grades);

        for (Subject subject : grades.keySet()) {
            List<Student> students = studentsSubjects.getOrDefault(subject, new ArrayList<>());
            students.add(student);
            studentsSubjects.put(subject, students);
        }
    }

    public boolean putSubjectWithStudentAndGrade(Subject subject, Student student, int grade) {
        if (gradesByStudents.containsKey(student)) {
            gradesByStudents.get(student).put(subject, grade);
            studentsSubjects.get(subject).add(student);
            return true;
        }
        return false;
    }

    public void removeStudent(Student student) {
        if (gradesByStudents.containsKey(student)) {
            Set<Subject> subjects = gradesByStudents.remove(student).keySet();
            for (Subject subject : subjects) {
                studentsSubjects.get(subject).remove(student);
            }
        }
    }

    public void printStudentGrades() {
        gradesByStudents.forEach((student, grades) ->
                System.out.printf("%s = %s%n", student, grades));
    }

    public void putSubjectWithStudents(Subject subject, List<Student> students) {
        studentsSubjects.put(subject, students);
    }

    public boolean putStudentWithSubject(Student student, Subject subject) {
        if (studentsSubjects.containsKey(subject)) {
            studentsSubjects.get(subject).add(student);
            return true;
        }
        return false;
    }

    public void removeStudentWithSubject(Student student, Subject subject) {
        if (studentsSubjects.containsKey(subject)) {
            List<Student> students = studentsSubjects.get(subject);
            students.remove(student);
            if (students.isEmpty()) {
                studentsSubjects.remove(subject);
            }
        }
    }

    public void printStudentsSubjects() {
        studentsSubjects.forEach((subject, studentsSubjects) ->
                System.out.printf("%s = %s%n", subject, studentsSubjects));
    }
}
