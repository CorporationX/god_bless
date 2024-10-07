package school.faang.JavaHashMap.BJS2_32448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students = new ArrayList<>();
    static Map<String, List<Student>> groupedStudents;

    public static void main(String[] args) {
        addStudent(new Student("Ivan", "Факультет компьютерных наук", 1));
        addStudent(new Student("Мария", "Факультет инженерии", 2));
        addStudent(new Student("Алексей", "Факультет экономики", 3));
        addStudent(new Student("Светлана", "Факультет гуманитарных наук", 1));
        addStudent(new Student("Дмитрий", "Факультет компьютерных наук", 2));
        addStudent(new Student("Елена", "Факультет инженерии", 3));
        addStudent(new Student("Анна", "Факультет экономики", 1));
        addStudent(new Student("Николай", "Факультет гуманитарных наук", 2));
        addStudent(new Student("Ольга", "Факультет компьютерных наук", 1));
        addStudent(new Student("Сергей", "Факультет инженерии", 3));
        addStudent(new Student("Кирилл", "Факультет экономики", 2));
        addStudent(new Student("Татьяна", "Факультет гуманитарных наук", 1));
        addStudent(new Student("Анастасия", "Факультет компьютерных наук", 1));
        addStudent(new Student("Павел", "Факультет инженерии", 2));
        addStudent(new Student("Евгений", "Факультет экономики", 3));

        addStudent(new Student("Dimoooooon", "Фильмография", 1));
        addStudent(new Student("Saneeeeeek", "Фильмография", 1));

        groupedStudents = groupByFacultyAndCourse(students);
        printGroupedStudents();

        removeStudent(new Student("Dimoooooon", "Фильмография", 1));
        removeStudent(new Student("Saneeeeeek", "Фильмография", 1));

        printGroupedStudents();

        searchStudents("Факультет инженерии",3);
        searchStudents("Факультет инженерии",2);

    }

    public static Map<String, List<Student>> groupByFacultyAndCourse(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for(Student student : students){
            String key = student.getFaculty() + " - " + student.getYear() + " курс ";
            groupedStudents.putIfAbsent(key, new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public static void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Студент " + student.getName() + " успешно добавлен.");
        } else {
            System.out.println("Студент " + student.getName() + " уже существует в списке.");
        }
    }

    public static void removeStudent(Student student){
        students.remove(student);
    }

    public static void searchStudents(String faculty, int course){
        for(Student student : students){
            if(student.getFaculty().equals(faculty) && student.getYear() == course){
                System.out.println(" Факультет " + student.getFaculty() +
                                   "\n Курс " + student.getYear() +
                                   "\n Студент " + student.getName());
            }
        }
    }

    public static void printGroupedStudents(){
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

