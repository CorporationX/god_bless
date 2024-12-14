package school.faang.doublecash.maincode;

import java.util.List;
import java.util.Map;

public class StudentService {
    public static void addStudent(Student student, Map<Subject, Integer> subjectAssessment, Map<Student,
            Map<Subject, Integer>> studentsMap) {
        studentsMap.put(student, subjectAssessment);
    }

    public static void addSubjectForStudent(Student student, Subject subject, int grade, Map<Student,
            Map<Subject, Integer>> studentsMap) {
        studentsMap.get(student).put(subject, grade);
    }

    public static void removeStudent(Student student, Map<Student, Map<Subject, Integer>> studentsMap) {
        studentsMap.remove(student);
    }

    public static void printAll(Map<Student, Map<Subject, Integer>> studentsMap) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    public static void addSubject(Subject subject, Student student, Map<Subject, List<Student>> subjectsMap,
                           List<Student> students) {
        for (Student student1 : students) {
            if (!student.equals(student1)) {
                students.add(student);
            }
        }

        subjectsMap.put(subject, students);
    }

    public static void addStudentForSubject(Student student, Subject subject,
                                     Map<Subject, List<Student>> subjectsMap) {
        subjectsMap.get(subject).add(student);
    }

    public static void removeStudent(Subject subject, Student student, Map<Subject, List<Student>> subjectsMap) {
        subjectsMap.get(subject).remove(student);
    }

    public static void printAllSubjects(Map<Subject, List<Student>> subjectsMap) {
        for (Map.Entry<Subject, List<Student>> entry : subjectsMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
