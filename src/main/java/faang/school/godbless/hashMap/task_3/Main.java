package faang.school.godbless.hashMap.task_3;

import faang.school.godbless.hashMap.task_3.model.Deanery;
import faang.school.godbless.hashMap.task_3.model.Student;

import java.util.*;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Map<Student, Integer> STUDENTS_STORAGE = new HashMap<>();
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Student igor = new Student("Igor", "fak1", 3);
        Student ivan = new Student("Ivan", "fak1",6);
        Student olga = new Student("Olga", "fak1",3);
        Student elena = new Student("Elena", "fak4",2);
        add(igor);
        add(ivan);
        add(olga);
        add(elena);
        Map<Deanery, List<Student>> deaneries = groupStudents(STUDENTS);
        System.out.println("Мапа до удаления: ");
        printAll(deaneries);
        remove(olga.getName(), olga.getFaculty(), olga.getYear());
        Map<Deanery, List<Student>> secondDeaneries = groupStudents(STUDENTS);
        System.out.println("Мапа после удаления: ");
        printAll(secondDeaneries);
        System.out.println("Результат поиска студента: ");
        findStudents(elena.getFaculty(), elena.getYear(), secondDeaneries);
    }

    private static void add(Student student) {
        STUDENTS.add(currentIndex, student);
        STUDENTS_STORAGE.put(student, currentIndex);
        currentIndex++;
    }

    private static void remove(String name, String faculty, int year) {
        int studentIndex = STUDENTS_STORAGE.remove(new Student(name, faculty, year));
        STUDENTS_STORAGE.forEach(((student, index) -> {
            if (STUDENTS_STORAGE.get(student) > studentIndex) {
                STUDENTS_STORAGE.put(student, index - 1);
            }
        }));
        STUDENTS.remove(studentIndex);
        currentIndex--;
    }


    public static void findStudents(String faculty, int year, Map<Deanery, List<Student>> deaneries) {
        List<Student> students = deaneries.get(new Deanery(faculty, year));
        if (students == null) {
            System.out.println("Студент не найден");
        } else  {
            students.forEach(System.out::println);
        }
    }

    private static void printAll(Map<Deanery, List<Student>> deaneries) {
        deaneries.forEach(((deanery, students) -> {
            System.out.println(deanery + ": ");
            students.forEach(student -> System.out.println(student.getName()));
        }));
        System.out.println();
    }

    private static Map<Deanery, List<Student>> groupStudents(List<Student> students) {
        Map<Deanery, List<Student>> deaneries = new HashMap<>();
        for (Student student : students) {
            List<Student> currentStudents = deaneries.computeIfPresent(new Deanery(student.getFaculty(), student.getYear()), (deanery, studentGroups) -> {
                studentGroups.add(student);
                return studentGroups;
            });
            if (currentStudents == null) {
                deaneries.computeIfAbsent(new Deanery(student.getFaculty(), student.getYear()), currentDeanery -> {
                    List<Student> group =  new ArrayList<>();
                    group.add(student);
                    return group;
                });
            }
        }
        return deaneries;
    }
}