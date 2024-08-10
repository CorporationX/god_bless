package faang.school.godbless.BJS2_19913;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AcademicRecordService {

    private Map<Student, Map<Subject, Integer>> studentGrades;
    private Map<Subject, List<Student>> studentsSubjects;

    public AcademicRecordService() {
        this.studentGrades = new HashMap<>();
        this.studentsSubjects = new HashMap<>();
    }

    public void put(Student student, Map<Subject, Integer> grades) {
        Map<Subject, Integer> subjectGrades = studentGrades.getOrDefault(student, new HashMap<>());
        subjectGrades.putAll(grades);
        studentGrades.put(student, subjectGrades);

        for (Subject subject : grades.keySet()) {
            List<Student> students = studentsSubjects.getOrDefault(subject, new ArrayList<>());
            students.add(student);
            studentsSubjects.put(subject, students);
        }
    }

    public boolean put(Subject subject, Student student, int grade) {
        if (studentGrades.containsKey(student)) {
            studentGrades.get(student).put(subject, grade);
            studentsSubjects.get(subject).add(student);
            return true;
        }
        return false;
    }

    public void remove(Student student) {
        if (studentGrades.containsKey(student)) {
            Set<Subject> subjects = studentGrades.remove(student).keySet();
            for (Subject subject : subjects) {
                studentsSubjects.get(subject).remove(student);
            }
        }
    }

    public void printStudentGrades() {
        studentGrades.forEach((student, grades) ->
                System.out.printf("%s = %s%n", student, grades));
    }

    public void put(Subject subject, List<Student> students) {
        List<Student> subjectStudents = studentsSubjects.getOrDefault(subject, new ArrayList<>());
        subjectStudents.addAll(students);
        studentsSubjects.put(subject, subjectStudents);
    }

    public boolean put(Student student, Subject subject) {
        if (studentsSubjects.containsKey(subject)) {
            studentsSubjects.get(subject).add(student);
            return true;
        }
        return false;
    }

    public void remove(Student student, Subject subject) {
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
