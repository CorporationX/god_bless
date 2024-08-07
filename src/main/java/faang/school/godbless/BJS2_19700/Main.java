package faang.school.godbless.BJS2_19700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final List<Student> students;
    public Main() {
        this.students = new ArrayList<>();
        students.add(new Student("Михаил", "Психология", 2015));
        students.add(new Student("Георгий", "Филология", 2016));
        students.add(new Student("Елена", "Машиностроение", 2017));
    }
    public Map<CompositeKeyFacultyYear, List<Student>> groupStudent(List<Student> studentList) {
        Map<CompositeKeyFacultyYear, List<Student>> groupingMap = new HashMap<>();
        for (Student student : studentList) {
            CompositeKeyFacultyYear compositeKeyFacultyYear = new CompositeKeyFacultyYear(student.getFaculty(), student.getYear());
            groupingMap.computeIfAbsent(compositeKeyFacultyYear, k -> new ArrayList<>()).add(student);
        }
        return groupingMap;
    }
    public void addStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }
    public void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) &&
                student.getFaculty().equals(faculty) &&
                student.getYear() == year);
    }
    public List<Student> findStudent(String faculty, int year) {
        List<Student> findingStudents = new ArrayList<>();
        for (Student student : students) {
            if(student.getFaculty().equals(faculty) && student.getYear() == year) {
                findingStudents.add(student);
            }
        }
        return findingStudents;
    }
    public void findAllGroupingStudents () {
        Map<CompositeKeyFacultyYear, List<Student>> groupedStudents = groupStudent(students);
        for (Map.Entry<CompositeKeyFacultyYear, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Группировка по факультетам и годам: " + entry.getKey());
            System.out.println("Студенты: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println("Инициализация студентов:");
        main.findAllGroupingStudents();

        System.out.println("Добавление нового студента 'Мария' на факультет 'Психология', 2015:");
        main.addStudent("Мария", "Психология", 2015);
        main.findAllGroupingStudents();

        System.out.println("Поиск студентов 'Психология', 2015:");
        List<Student> foundStudents = main.findStudent("Психология", 2015);
        for (Student student : foundStudents) {
            System.out.println(student);
        }

        System.out.println("Удаление студента 'Георгий' с факультета 'Филология', 2016:");
        main.removeStudent("Георгий", "Филология", 2016);
        main.findAllGroupingStudents();
    }
}
