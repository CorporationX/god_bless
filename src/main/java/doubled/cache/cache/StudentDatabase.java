package doubled.cache.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String studentName, Map<Subject, Integer> subjectsAndGrades) {
        if (studentName == null || subjectsAndGrades == null || studentName.isBlank()) {
            System.out.println("Student name or his map with grades is null!");
            return;
        }

        this.studentSubjects.putIfAbsent(new Student(studentName), subjectsAndGrades);

        for (Map.Entry<Subject, Integer> subIntEntry : subjectsAndGrades.entrySet()) {
            this.subjectStudents.putIfAbsent(subIntEntry.getKey(), new ArrayList<>());
            this.subjectStudents.get(subIntEntry.getKey()).add(new Student(studentName));
        }
    }

    public void addSubjectToExistingStudent(String existStudent, String subject, Integer grade) {
        if (existStudent == null || subject == null || grade == null) {
            System.out.println("Student name, subject or grades is null!");
        } else if (!this.studentSubjects.containsKey(new Student(existStudent))) {
            System.out.printf("Student %s doesn t exist!", existStudent);
        } else if (this.studentSubjects.get(new Student(existStudent)).containsKey(new Subject(subject))) {
            System.out.printf("Subject %s for student %s already exists!");
        } else {
            this.studentSubjects.get(new Student(existStudent)).put(new Subject(subject), grade);
            this.subjectStudents.put(new Subject(subject), new ArrayList<>());
            this.subjectStudents.get(new Subject(subject)).add(new Student(existStudent));
        }
    }

    public void removeStudentAndData(String studentName) {
        if (studentName == null) {
            System.out.println("Student name, subject or grades is null!");
            return;
        } else if (!this.studentSubjects.containsKey(new Student(studentName))) {
            System.out.printf("Student %s doesn t exist!", studentName);
            return;
        }
        this.studentSubjects.remove(new Student(studentName));
        for (Map.Entry<Subject, List<Student>> subEntry : this.subjectStudents.entrySet()) {
            Iterator<Student> iterator = subEntry.getValue().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(new Student(studentName))) {
                    iterator.remove();
                }
            }
        }
    }

    public void printAllStudentsInfo() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : this.studentSubjects.entrySet()) {
            System.out.printf("Student %s %nHas next subjects and grades: %n", studentMapEntry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectIntegerEntry : studentMapEntry.getValue().entrySet()) {
                System.out.printf("Subject %s: grade - %d %n", subjectIntegerEntry.getKey().getName(),
                        subjectIntegerEntry.getValue());
            }
            System.out.println();
        }
    }
}
