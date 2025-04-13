package school.faang.bjs2_68766;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    /* использовал Set, так как Map<Student, Map<Subject, Integer>> не позволяет
        содержать несколько оценок с одинаковыми студентом и предметом, в таком
        случае нет смысла хранить и повторяющихся студентов для предмета
     */
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addNewStudent(Student student, Map<Subject, Integer> subjects) {
        if (student == null || subjects == null) {
            throw new NullPointerException();
        }
        if (this.studentSubjects.containsKey(student)) {
            throw new StudentAlreadyExistsException("Student " + student.name() + " already exists");
        }
        this.studentSubjects.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            Set<Student> students = this.subjectStudents.getOrDefault(subject, new HashSet<>());
            students.add(student);
            this.subjectStudents.put(subject, students);
        }
    }

    public void addNewSubjectForExistsStudent(Student student, Subject subject, Integer assessment) {
        if (student == null || subject == null || assessment == null) {
            throw new NullPointerException();
        }
        if (!this.studentSubjects.containsKey(student)) {
            throw new StudentNotFoundException("Student " + student.name() + " not found");
        }
        if (this.subjectStudents.containsKey(subject)) {
            throw new SubjectAlreadyExistsException("Subject " + subject.name() + " already exists");
        }
        Map<Subject, Integer> subjects = this.studentSubjects.get(student);
        subjects.put(subject, assessment);
        this.studentSubjects.put(student, subjects);
        Set<Student> students = new HashSet<>();
        students.add(student);
        this.subjectStudents.put(subject, students);
    }

    public void removeStudentAndSubjectsList(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        if (!this.studentSubjects.containsKey(student)) {
            throw new StudentNotFoundException("Student " + student.name() + " not found");
        }
        this.studentSubjects.remove(student);
        for (Set<Student> students : this.subjectStudents.values()) {
            students.remove(student);
        }
    }

    public void printAllStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> students : this.studentSubjects.entrySet()) {
            System.out.println(students);
        }
    }

    /*
     По условию задачи "Добавление нового предмета и списка студентов, изучающих его"
     не указаны оценки, поэтому оценку по предмету устанавливаю null
     */
    public void addNewSubject(Subject subject, Set<Student> students) {
        if (subject == null || students == null) {
            throw new NullPointerException();
        }
        if (this.subjectStudents.containsKey(subject)) {
            throw new SubjectAlreadyExistsException("Subject " + subject.name() + " already exists");
        }
        this.subjectStudents.put(subject, students);
        for (Student student : students) {
            Map<Subject, Integer> subjects = this.studentSubjects.getOrDefault(student, new HashMap<>());
            subjects.put(subject, null);
            this.studentSubjects.put(student, subjects);
        }
    }

    public void addExistsStudentsInExistsSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new NullPointerException();
        }
        if (!this.studentSubjects.containsKey(student)) {
            throw new StudentNotFoundException("Student " + student.name() + " not found");
        }
        if (!this.subjectStudents.containsKey(subject)) {
            throw new SubjectNotFoundException("Subject " + student.name() + " not found");
        }
        Map<Subject, Integer> subjects = this.studentSubjects.get(student);
        subjects.put(subject, null);
        Set<Student> students = this.subjectStudents.get(subject);
        students.add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            throw new NullPointerException();
        }
        if (!this.studentSubjects.containsKey(student)) {
            throw new StudentNotFoundException("Student " + student.name() + " not found");
        }
        if (!this.subjectStudents.containsKey(subject)) {
            throw new SubjectNotFoundException("Subject " + student.name() + " not found");
        }
        if (!this.subjectStudents.get(student).contains(subject)) {
            throw new StudentInSubjectNotFoundException("Student " + student.name()
                    + " in subject " + subject.name() + " not found");
        }
        this.subjectStudents.get(student).remove(subject);
        this.studentSubjects.get(subject).remove(student);
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, Set<Student>> subject : this.subjectStudents.entrySet()) {
            System.out.println(subject);
        }
    }
}
