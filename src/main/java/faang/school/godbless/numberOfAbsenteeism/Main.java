package faang.school.godbless.numberOfAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Сергей", "математика", 4));
        students.add(new Student("Рома", "русский", 3));
        students.add(new Student("Слава", "математика", 4));
        students.add(new Student("Вася", "русский ", 3));
        students.add(new Student("Юля", "русский", 3));
        students.add(new Student("Нина", "математика", 4));
        addStudent(students, new Student("Вика", "математика", 4));
        deleteStudent(students, "Нина", "математика", 4);
        System.out.println(sortingStudents(students));
        System.out.println(getGroupStudents(students,"математика", 4));
    }

    static HashMap<String, List<Student>> sortingStudents(List<Student> listStudents) {
        HashMap<String, List<Student>> sortingListStudent = new HashMap<>();
        for(Student student: listStudents) {
            String key = student.getFacilty() + student.getYear();
            sortingListStudent.putIfAbsent(key, new ArrayList<>());
            sortingListStudent.get(key).add(student);
        }
        return sortingListStudent;
    }

    static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    static void deleteStudent(List<Student> students, String name, String facilty, int year) {
        for (Student student: students) {
            if (student.getName().equals(name) && student.getFacilty().equals(facilty) && student.getYear() == year) {
                students.remove(student);
                return;
            }
        }
    }

    static List<Student> getGroupStudents(List<Student> students, String name, int facilty) {
        HashMap<String, List<Student>> sortingListStudent = sortingStudents(students);
        return sortingListStudent.get(name + facilty);
    }
}
