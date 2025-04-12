package school.faang.doubleHash;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StudentDatabase {

    Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();

    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    //Добавление нового студента и его предметов с оценками
    public void addStudentWithSubject(Student student, Map<Subject, Integer> grades) {
        studentSubject.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    //Добавление нового предмета для существующих студентов с оценками
    public void addSubjectForExistingStudent(Student student, Subject subject, int grade) {
        studentSubject.putIfAbsent(student, new HashMap<>());
        studentSubject.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);

        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    //Удалить студента и его предметы
    public void deleteStudent(Student student, Subject subject) {
        studentSubject.remove(student);
        subjectStudents.get(subject).remove(student);
        subjectStudents.remove(subject);

        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    //Печатать всех студентов и предметы
    public void printStudentWithGrade() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println(subject);
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }

    //Добавление нового предмета и списка студентов
    public void addSubjectAndStudent(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubject.putIfAbsent(student, new HashMap<>());
            studentSubject.get(student).put(subject, null);
        }

        System.out.println(subjectStudents);
        System.out.println(studentSubject);
    }

    //Добавление предмета к существующему студенту
    public void addSubjectExistingStudent(Subject subject, Student student) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubject.putIfAbsent(student, new HashMap<>());
        studentSubject.get(student).put(subject, null);

        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    //Удаление студента из предмета
    public void deleteStudentFromSubject(Student student, Subject subject) {
        List<Student> studentList = subjectStudents.get(subject);
        if (studentList != null) {
            studentList.remove(student);
        }
        Map<Subject, Integer> subjectIntegerMap = studentSubject.get(student);
        if (subjectIntegerMap != null) {
            subjectIntegerMap.remove(subject);
        }
    }

    //Вывести все предметы и студентов
    public void printSubjectAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println(subject);
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }
}
