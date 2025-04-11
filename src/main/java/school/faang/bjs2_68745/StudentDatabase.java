package school.faang.bjs2_68745;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects; // хранит информацию о студентах, их предметах и оценках.
    private final Map<Subject, List<Student>> subjectStudents; // хранит информацию о предметах и списке студентов, изучающих каждый предмет.

    public StudentDatabase() {
        this.studentSubjects = new HashMap<>();
        this.subjectStudents = new HashMap<>();
    }

    //    Добавление нового студента и его предметов с оценками.
    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).putAll(subjects);
        for (Subject subject : studentSubjects.get(student).keySet()) {
            putStudentIntoSubjectStudentsMap(student, subject);
        }
    }

    //    Добавление нового предмета для существующего студента с оценкой.
    public void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, grade);
        putStudentIntoSubjectStudentsMap(student, subject);
    }

    //    Удаление студента и его предметов.
    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((subject, students) -> students.remove(student));
    }

    //    Вывод списка всех студентов и их оценок по предметам.
    public void printAllStudents() {
        studentSubjects.forEach((student, subjectsMap) -> {
            System.out.printf("Студент: %s\n", student.name());
            subjectsMap.forEach((subject, grade)
                -> System.out.printf("\t%s - %d\n", subject.name(), grade));
        });
    }

    //    Добавление нового предмета и списка студентов, изучающих его.
    public void addSubjectWithStudentList(Subject subject, List<Student> students) {
        for (Student student : students) {
            addStudentToSubjects(student, subject);
        }
    }

    //    Добавление студента к существующему предмету.
    public void addStudentToSubjects(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, null);
        putStudentIntoSubjectStudentsMap(student, subject);
    }

    //    Удаление студента из предмета.
    public void removeStudentFromSubject(Student student, Subject subject) {
        /*
         * private final Map<Student, Map<Subject, Integer>> studentSubjects; // хранит информацию о студентах, их предметах и оценках.
         * private final Map<Subject, List<Student>> subjectStudents; // хранит информацию о предметах и списке студентов, изучающих каждый предмет.
         */
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
        }
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    //    Вывод списка всех предметов и студентов, изучающих их.
    public void printAllSubject() {
        //Map<Subject, List<Student>> subjectStudents
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("Предмет: %s\n", subject.name());
            students.forEach(student -> System.out.printf("\tСтудент: %s\n", student.name()));
        });
    }

    private void putStudentIntoSubjectStudentsMap(Student student, Subject subject) {
        List<Student> students = subjectStudents.getOrDefault(subject, new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
            subjectStudents.put(subject, students);
        }
    }
}
